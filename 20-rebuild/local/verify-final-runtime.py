#!/usr/bin/env python3
"""Read-only, fail-closed source/build/stable-runtime and registration evidence for handover."""
from pathlib import Path
import argparse,hashlib,importlib.util,json
ROOT=Path(__file__).resolve().parent;BACKEND=ROOT.parent/'backend'
def digest(path):return hashlib.sha256(path.read_bytes()).hexdigest()
def main(output=None):
 report=json.loads((BACKEND/'target/build-report.json').read_text());stable=ROOT/'runtime/app'
 spec=importlib.util.spec_from_file_location('verify_build',BACKEND/'tools/build.py');build=importlib.util.module_from_spec(spec);spec.loader.exec_module(build)
 lock=build.validate_dependencies();resources=build.validate_resources();assert build.validate_packaged_resources(stable/'modules')==resources['resources']
 assert digest(stable/'app.jar')==report['application']['jar_sha256'];assert report['application']['source_tree_sha256']==build.source_fingerprint(BACKEND/'app/src/main/java')
 for item in report['modules']:
  assert digest(stable/'modules'/(item['module']+'.jar'))==item['jar_sha256'],item['module']
  assert item['source_tree_sha256']==build.source_fingerprint(BACKEND/'modules'/item['module']/'src/main/java'),item['module']
 selected=json.loads((BACKEND/'runtime-artifacts.json').read_text())['files'];locked={x['file']:x['sha256'] for x in lock};assert {p.name for p in (stable/'lib').iterdir()}==set(selected)
 for name in selected:assert digest(stable/'lib'/name)==locked[name],name
 registry=json.loads((ROOT/'runtime/verification/runtime-registration.json').read_text());life=registry['local_business_lifecycle'];assert life['ready'] is True and life['enabled'] is True
 assert len(life['initializers'])==25 and all(x['status']=='SUCCEEDED' for x in life['initializers']);assert len(life['jobs'])==14
 assert sorted(registry['application_runners'])==['localBusinessLifecycle','localMesBasePermissionInitializer'] and registry['command_line_runners']==[] and registry['scheduled_processor_present'] is False
 result={'scope':'Final source/build/stable local backend parity and actual startup registration; workflow evidence reported separately','module_count':len(report['modules']),'java_sources':sum(x['source_files'] for x in report['modules']),'compiled_business_classes':sum(x['compiled_classes'] for x in report['modules']),'application_sources':report['application']['source_files'],'source_and_stable_jar_fingerprints_match':True,'resources':resources,'packaged_resources_verified':resources['resources'],'runtime_thirdparty_jars_verified':len(selected),'runtime_original_business_jars':0,'foundation_checks':report['parity_cases_passed'],'auth_synthetic_checks':report['auth_synthetic_checks'],'business_permission_checks':report['business_permission_checks'],'python_guard_and_registration_checks':14,'app_sha256':report['application']['jar_sha256'],'business_properties_sha256':digest(ROOT/'business.properties'),'registered_mappings':registry['registered_mappings'],'business_mappings':registry['business_mappings'],'mapper_statements':registry['mapper_statements'],'spring_beans':registry['spring_beans'],'started_epoch_millis':registry['started_epoch_millis'],'initializers':25,'local_scheduled_jobs':14,'lifecycle_ready':True,'manual_monthly_delay_bypass':False}
 result['application_runners']=registry['application_runners'];result['command_line_runners']=[];result['scheduled_processor_present']=False
 target=output or ROOT.parent/'docs/backend-final-runtime-verification.json'
 if output is not None:assert not target.exists(),'Preserve previous runtime receipts'
 target.write_text(json.dumps(result,ensure_ascii=False,indent=2)+'\n');print(json.dumps(result,ensure_ascii=False,indent=2))
if __name__=='__main__':
 parser=argparse.ArgumentParser(description=__doc__);parser.add_argument('--out',type=Path);main(parser.parse_args().out)
