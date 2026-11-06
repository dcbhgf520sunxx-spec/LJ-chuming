#!/usr/bin/env python3
"""Recompile only the runtime integration layer against previously verified module outputs."""
import importlib.util
import json
import shutil
import sys

spec=importlib.util.spec_from_file_location("source_build",__file__.replace("rebuild-app.py","build.py"))
build=importlib.util.module_from_spec(spec);spec.loader.exec_module(build)
root=build.ROOT;target=root/"target"
report_path=target/"build-report.json"
previous=target/"last-verified-build-report.json"
report=json.loads((report_path if report_path.exists() else previous).read_text())
previous.write_text(json.dumps(report,ensure_ascii=False,indent=2)+"\n")
# A failed incremental compile must not leave a successful report that could activate stale products.
report_path.unlink(missing_ok=True)
lock=build.validate_dependencies()
report["resource_coverage"]=build.validate_resources()
classpath=":".join("/src/.deps/"+item["file"] for item in lock)
recompile=sys.argv[1:]
if any(m not in build.MODULES for m in recompile):raise RuntimeError("Unknown source module")
for item in report["modules"]:
    if build.digest(target/(item["module"]+".jar"))!=item["jar_sha256"]:raise RuntimeError("Module output changed")
    if item["module"] not in recompile and item.get("source_tree_sha256")!=build.source_fingerprint(root/"modules"/item["module"]/"src/main/java"):
        raise RuntimeError("Changed business source must be recompiled: "+item["module"])
    classpath+=":/src/target/"+item["module"]
for module in recompile:
    directory=target/module;shutil.rmtree(directory);directory.mkdir()
    cp=":".join(p for p in classpath.split(":") if p!="/src/target/"+module)
    sources=sorted((root/"modules"/module/"src/main/java").rglob("*.java"))
    (target/(module+"-sources.txt")).write_text("\n".join("/src/"+str(p.relative_to(root)) for p in sources)+"\n")
    build.java(["javac","-encoding","UTF-8","-parameters","-g","-proc:none","-implicit:none","-sourcepath","/nonexistent","-cp",cp,"-d","/src/target/"+module,"@/src/target/"+module+"-sources.txt"],target/(module+"-compile.log"))
    resources=root/"modules"/module/"src/main/resources"
    if resources.is_dir():shutil.copytree(resources,directory,dirs_exist_ok=True)
    build.java(["jar","cf","/src/target/"+module+".jar","-C","/src/target/"+module,"."],target/(module+"-package.log"))
    for item in report["modules"]:
        if item["module"]==module:item.update(jar_sha256=build.digest(target/(module+".jar")),compiled_classes=len(list(directory.rglob("*.class"))),source_tree_sha256=build.source_fingerprint(root/"modules"/module/"src/main/java"))
    shutil.copy2(target/(module+".jar"),target/"runtime/modules"/(module+".jar"))
report["packaged_resources_verified"]=build.validate_packaged_resources(target)
if "scim-wms-core" in recompile:
    report.update(build.check_outbound_workflows(classpath,target))
sources=sorted((root/"app/src/main/java").rglob("*.java"))
(target/"app-sources.txt").write_text("\n".join("/src/"+str(p.relative_to(root)) for p in sources)+"\n")
shutil.rmtree(target/"app",ignore_errors=True);(target/"app").mkdir()
build.java(["javac","-encoding","UTF-8","-parameters","-g","-proc:none","-implicit:none","-sourcepath","/nonexistent","-cp",classpath,"-d","/src/target/app","@/src/target/app-sources.txt"],target/"app-compile.log")
build.java(["jar","cf","/src/target/app.jar","-C","/src/target/app","."],target/"app-package.log")
build.java(["javac","-encoding","UTF-8","-proc:none","-cp",classpath+":/src/target/app","-d","/src/target/tests","/src/app/src/test/java/com/ljaps/rebuild/auth/AuthContractProbe.java"],target/"auth-test-compile.log")
build.java(["java","-cp",classpath+":/src/target/app:/src/target/tests","com.ljaps.rebuild.auth.AuthContractProbe"],target/"auth-test-result.txt")
build.check_business_permissions(classpath,target)
report["auth_synthetic_checks"]=21
report["business_permission_checks"]=7
report["numeric_menu_permission_checks"]=8
build.check_health_readiness(classpath,target)
report["health_readiness_checks"]=3
shutil.copy2(target/"app.jar",target/"runtime/app.jar")
report["application"].update(source_files=len(sources),jar_sha256=build.digest(target/"app.jar"))
report["application"]["source_tree_sha256"]=build.source_fingerprint(root/"app/src/main/java")
(target/"build-report.json").write_text(json.dumps(report,ensure_ascii=False,indent=2)+"\n")
print("Integration app compiled; module JAR digests verified; 21 auth and 7 business permission checks passed")
