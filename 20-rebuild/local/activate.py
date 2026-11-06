#!/usr/bin/env python3
"""Activate a verified local build without mounting the disposable target directory."""
import hashlib
import json
from pathlib import Path
import shutil
import subprocess
import tempfile
import importlib.util

ROOT = Path(__file__).resolve().parent


def compose(*args):
    subprocess.run(["docker", "compose", "-f", str(ROOT / "compose.json"), *args], cwd=ROOT, check=True)


def main():
    subprocess.run(["python3", str(ROOT / "init-config.py")], check=True)
    target = ROOT.parent / "backend/target"
    report = json.loads((target / "build-report.json").read_text())
    if report.get("original_business_jars_on_classpath") != 0 or report.get("parity_cases_passed") != 9 or report.get("auth_synthetic_checks") != 21 or report.get("health_readiness_checks") != 3 or report.get("business_permission_checks") != 7 or report.get("numeric_menu_permission_checks") != 8:
        raise RuntimeError("A verified source build is required before activation")
    if report.get("outsourcing_submission_checks") != 4 or report.get("outsourcing_batch_submission_checks") != 4 or report.get("outbound_revocation_checks") != 10:
        raise RuntimeError("Current outbound submission and revocation build gates are required before activation")
    spec=importlib.util.spec_from_file_location("source_build",ROOT.parent / "backend/tools/build.py")
    build=importlib.util.module_from_spec(spec);spec.loader.exec_module(build)
    if [item["module"] for item in report["modules"]] != list(build.MODULES) or report.get("resource_coverage") != build.validate_resources():
        raise RuntimeError("The complete source module and resource inventory must be built")
    for item in report["modules"]:
        if item.get("source_tree_sha256") != build.source_fingerprint(build.ROOT / "modules" / item["module"] / "src/main/java"):
            raise RuntimeError("Business source changed after compilation: " + item["module"])
    if report["application"].get("source_tree_sha256") != build.source_fingerprint(build.ROOT / "app/src/main/java"):
        raise RuntimeError("Application source changed after compilation")
    products = [("app.jar", report["application"]["jar_sha256"])]
    products += [("modules/" + m["module"] + ".jar", m["jar_sha256"]) for m in report["modules"]]
    for name, expected in products:
        if hashlib.sha256((target / "runtime" / name).read_bytes()).hexdigest() != expected:
            raise RuntimeError("Runtime artifact differs from the verified build: " + name)
    build.validate_packaged_resources(target / "runtime/modules")
    runtime = ROOT / "runtime"
    runtime.mkdir(exist_ok=True)
    with tempfile.TemporaryDirectory(prefix=".stage-", dir=runtime) as temp:
        staged = Path(temp) / "app"
        shutil.copytree(target / "runtime", staged)
        # Only the new service is stopped; the reference stack and database keep running.
        compose("stop", "backend")
        shutil.rmtree(runtime / "app", ignore_errors=True)
        staged.rename(runtime / "app")
    compose("up", "-d", "--force-recreate", "backend")
    compose("up", "-d", "web")
    compose("exec", "-T", "web", "nginx", "-s", "reload")
    print("Local source build activated. Verify health, HTTP contracts and the real browser before acceptance.")


if __name__ == "__main__":
    main()
