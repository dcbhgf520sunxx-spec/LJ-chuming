#!/usr/bin/env python3
"""Compile the IFC boundary probe and verify real/synthetic aggregates using read-only MySQL CTEs."""
import argparse
from decimal import Decimal
import json
from pathlib import Path
import subprocess
import tempfile
import time

ROOT = Path(__file__).resolve().parents[1]
FIELDS = ["mark", "name", "quantity", "totalGrossWeight", "complete", "inProduction", "inbound", "outbound",
          "received", "installed", "completeWeight", "inProductionWeight", "inboundWeight", "outboundWeight",
          "receivedWeight", "installedWeight"]


def original_sql():
    sources = [("mes_building_task", "complete_quantity", "task_type_enum=2", "complete"),
               ("mes_building_task", "in_production_quantity", "task_type_enum=2", "inProduction"),
               ("mes_building_warehouse_summary", "quantity", "product_type=2 AND type=1", "inbound"),
               ("mes_building_warehouse_summary", "quantity", "product_type=2 AND type=2", "outbound"),
               ("project_receiving_summary", "quantity", "product_type=2", "received"),
               ("project_install_summary", "actual_quantity", "product_type=2", "installed")]
    fields = ["a.serial_number AS mark", "MAX(a.name) AS name", "SUM(a.quantity) AS quantity",
              "SUM(a.quantity*COALESCE(a.gross_weight,0)) AS totalGrossWeight"]
    amounts = [("(SELECT COALESCE(SUM(t." + column + "),0) FROM " + table
                + " t WHERE t.product_id=a.id AND t.bool_delete_enum=0 AND " + condition + ")", alias)
               for table, column, condition, alias in sources]
    fields += ["SUM(" + amount + ") AS " + alias for amount, alias in amounts]
    fields += ["SUM(" + amount + "*COALESCE(a.gross_weight,0)) AS " + alias + "Weight" for amount, alias in amounts]
    return "SELECT " + ",".join(fields) + " FROM tech_artifact a WHERE a.bool_delete_enum=0 AND a.monomer_id=? AND a.area_id=? GROUP BY a.serial_number"


def fixture_ctes():
    # Hand-checked: duplicate marks have different weights; null aggregates, deleted/source types and out-of-scope rows.
    tables = {
        "tech_artifact": (["id", "serial_number", "name", "quantity", "gross_weight", "monomer_id", "area_id", "bool_delete_enum"], [
            [1, "shared", "alpha", 3, Decimal("2.5"), 105, 354, 0],
            [2, "shared", "omega", 4, Decimal("4"), 105, 354, 0],
            [3, "nulls", None, None, Decimal("2"), 105, 354, 0],
            [4, "untouched", "zero", 0, Decimal("7"), 105, 354, 0],
            [5, "shared", "deleted", 999, Decimal("999"), 105, 354, 1],
            [6, "outside", "monomer", 999, Decimal("999"), 999, 354, 0],
            [7, "outside", "area", 999, Decimal("999"), 105, 999, 0],
            [8, None, "unmarked", 2, Decimal("1"), 105, 354, 0],
            [9, "null-weight", "no weight", 2, None, 105, 354, 0]]),
        "mes_building_task": (["product_id", "complete_quantity", "in_production_quantity", "task_type_enum", "bool_delete_enum"], [
            [1, 1, 2, 2, 0], [1, 2, None, 2, 0], [2, 4, 1, 2, 0], [3, None, None, 2, 0],
            [1, 999, 999, 1, 0], [1, 999, 999, 2, 1], [5, 999, 999, 2, 0], [6, 999, 999, 2, 0],
            [7, 999, 999, 2, 0], [999, 999, 999, 2, 0], [9, 1, 3, 2, 0]]),
        "mes_building_warehouse_summary": (["product_id", "quantity", "product_type", "type", "bool_delete_enum"], [
            [1, 2, 2, 1, 0], [1, None, 2, 1, 0], [1, 1, 2, 2, 0], [2, 3, 2, 1, 0],
            [2, 2, 2, 2, 0], [2, 1, 2, 2, 0], [3, None, 2, 1, 0], [1, 999, 1, 1, 0],
            [1, 999, 2, 1, 1], [1, 999, 2, 3, 0], [1, 999, 2, None, 0], [999, 999, 2, 1, 0],
            [9, 1, 2, 1, 0], [9, 1, 2, 2, 0]]),
        "project_receiving_summary": (["product_id", "quantity", "product_type", "bool_delete_enum"], [
            [1, 1, 2, 0], [1, 2, 2, 0], [2, 2, 2, 0], [3, None, 2, 0], [1, 999, 1, 0],
            [1, 999, 2, 1], [999, 999, 2, 0], [9, 2, 2, 0]]),
        "project_install_summary": (["product_id", "actual_quantity", "product_type", "bool_delete_enum"], [
            [1, 1, 2, 0], [2, 1, 2, 0], [2, 1, 2, 0], [3, None, 2, 0], [1, 999, 1, 0],
            [1, 999, 2, 1], [999, 999, 2, 0], [9, 1, 2, 0]])}

    def literal(value):
        if value is None:
            return "NULL"
        if isinstance(value, str):
            return "'" + value.replace("'", "''") + "'"
        if isinstance(value, Decimal):
            return "CAST(" + str(value) + " AS DECIMAL(20,4))"
        return str(value)

    return ",".join(name + "(" + ",".join(columns) + ") AS ("
                    + " UNION ALL ".join("SELECT " + ",".join(map(literal, row)) for row in rows) + ")"
                    for name, (columns, rows) in tables.items())


def bind(query, monomer, area):
    return query.replace("?", str(monomer), 1).replace("?", str(area), 1)


def main():
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument("--mysql-container", default="ljaps-bim-restore-20261110-bulk-mysql")
    parser.add_argument("--database", default="plm7_web_preview")
    parser.add_argument("--evidence", type=Path)
    args = parser.parse_args()
    evidence = args.evidence or Path(tempfile.mkdtemp(prefix="ljaps-ifc-backend-probe-"))
    evidence.mkdir(parents=True, exist_ok=True)
    (evidence / "classes").mkdir(exist_ok=True)
    cp = ":".join(["/src/.deps/*"] + ["/src/target/" + module for module in json.loads((ROOT / "source-modules.json").read_text())])
    java = ["docker", "run", "--rm", "--network", "none", "--memory", "1g", "-v", str(ROOT) + ":/src:ro",
            "-v", str(evidence.resolve()) + ":/probe", "-w", "/src", "eclipse-temurin:8-jdk"]
    compile_result = subprocess.run(java + ["javac", "-encoding", "UTF-8", "-parameters", "-proc:none", "-implicit:none",
        "-sourcepath", "/nonexistent", "-cp", cp, "-d", "/probe/classes",
        "/src/app/src/main/java/com/ljaps/rebuild/business/IfcModelController.java",
        "/src/app/src/test/java/com/ljaps/rebuild/business/IfcPerformanceProbe.java"], capture_output=True, text=True)
    (evidence / "compile.log").write_text(compile_result.stdout + compile_result.stderr)
    if compile_result.returncode:
        raise AssertionError("Isolated probe compilation failed: " + str(evidence / "compile.log"))
    http = subprocess.run(java + ["java", "-cp", "/probe/classes:" + cp, "com.ljaps.rebuild.business.IfcPerformanceProbe",
                                  "/probe/progress.sql"], capture_output=True, text=True)
    (evidence / "http.log").write_text(http.stdout + http.stderr)
    query = (evidence / "progress.sql").read_text()

    def rows(sql):
        transaction = "SET SESSION TRANSACTION ISOLATION LEVEL REPEATABLE READ; START TRANSACTION WITH CONSISTENT SNAPSHOT, READ ONLY;\n" + sql + ";\nCOMMIT;"
        result = subprocess.run(["docker", "exec", "-i", args.mysql_container, "sh", "-c",
            'MYSQL_PWD="$MYSQL_ROOT_PASSWORD" exec mysql -uroot --batch --raw "$1"', "sh", args.database],
            input=transaction, capture_output=True, text=True)
        if result.returncode:
            raise AssertionError("Read-only SQL failed: " + result.stderr)
        lines = result.stdout.splitlines()
        if not lines:
            return []
        assert lines[0].split("\t") == FIELDS, "Progress endpoint fields/order changed"
        data = []
        for line in lines[1:]:
            values = line.split("\t")
            data.append(tuple(None if value == "NULL" else value if index < 2 else Decimal(value)
                              for index, value in enumerate(values)))
        return sorted(data, key=lambda row: (row[0] is not None, row[0] or ""))

    reports = []
    for monomer, area in [(105, 354), (679, 1412)]:
        before_start = time.perf_counter()
        before = rows(bind(original_sql(), monomer, area))
        before_ms = (time.perf_counter() - before_start) * 1000
        after_start = time.perf_counter()
        after = rows(bind(query, monomer, area))
        after_ms = (time.perf_counter() - after_start) * 1000
        assert before == after, "Real-area quantities, weights, names or nulls changed"
        reports.append({"monomer": monomer, "area": area, "rows": len(after), "exactResults": True,
                        "originalMsIncludingClient": round(before_ms, 3), "currentMsIncludingClient": round(after_ms, 3)})
    fixture = fixture_ctes()
    candidate = bind(query, 105, 354).strip()
    fixture_query = "WITH " + fixture + "," + candidate[5:] if candidate.upper().startswith("WITH ") else "WITH " + fixture + " " + candidate
    fixture_rows = rows(fixture_query)
    shared = ["shared", "omega", 7, "23.5", 7, 3, 5, 4, 5, 3, "23.5", 9, 17, "14.5", "15.5", "10.5"]
    expected = [tuple([None, "unmarked"] + list(map(Decimal, [2, 2] + [0] * 12))),
                tuple(["null-weight", "no weight"] + list(map(Decimal, [2, 0, 1, 3, 1, 1, 2, 1] + [0] * 6))),
                tuple(["nulls", None, None, None] + [Decimal(0)] * 12),
                tuple(shared[:2] + list(map(Decimal, shared[2:]))),
                tuple(["untouched", "zero"] + [Decimal(0)] * 14)]
    assert fixture_rows == expected, "Synthetic duplicate-mark weights/nulls/source types/soft-delete filtering changed"
    empty = bind(query, 999, 999).strip()
    empty_query = "WITH " + fixture + "," + empty[5:] if empty.upper().startswith("WITH ") else "WITH " + fixture + " " + empty
    assert rows(empty_query) == [], "An empty authorized area must have no progress rows"
    (evidence / "fixtures.sql").write_text(fixture_query + ";\n")
    failures = []
    if http.returncode:
        failures.append("private authenticated conditional HTTP responses: " + str(evidence / "http.log"))
    if reports[0]["currentMsIncludingClient"] * 2 >= reports[0]["originalMsIncludingClient"]:
        failures.append("large-area aggregate must improve by at least 2x (including client overhead)")
    report = {"httpCachePassed": http.returncode == 0, "syntheticAggregateFixturesPassed": True,
              "readOnlyTransactions": True, "schemaOrDataModified": False, "areas": reports, "failures": failures}
    (evidence / "report.json").write_text(json.dumps(report, indent=2) + "\n")
    print(json.dumps(report, indent=2))
    print("Evidence: " + str(evidence))
    assert not failures, "; ".join(failures)


if __name__ == "__main__":
    main()
