#!/usr/bin/env python3
"""Run source-only monthly-production probe against the isolated QA clone; all fixtures roll back."""
from pathlib import Path
import json,subprocess,shutil
from provision import ROOT
QA=ROOT/'runtime/lifecycle-qa';COMPOSE=QA/'compose.json'
def main():
 name='ProductionMonthlyDatabaseProbe';source=ROOT.parent/'backend/app/src/test/java/com/ljaps/rebuild/business'/f'{name}.java'
 (QA/'evidence'/source.name).write_text(source.read_text());report=QA/'evidence/production-monthly-database-verification.json';report.unlink(missing_ok=True)
 command=['docker','compose','-f',str(COMPOSE),'run','--rm','-T','--no-deps','--name','ljaps-lifecycle-production-monthly-probe','-e','LJAPS_LIFECYCLE_ENABLED=false','-e','LJAPS_LIFECYCLE_QA_RUN_ALL=false','-e','LJAPS_REGISTRATION_EVIDENCE=/evidence/production-monthly-registration.json','backend','sh','-c',f"javac -encoding UTF-8 -cp '/app/app.jar:/app/modules/*:/app/lib/*' -d /evidence /evidence/{name}.java && exec java -Xms128m -Xmx768m -cp '/evidence:/app/app.jar:/app/modules/*:/app/lib/*' com.ljaps.rebuild.business.{name}"]
 with (QA/'production-monthly-probe.log').open('wb') as output:subprocess.run(command,stdout=output,stderr=subprocess.STDOUT,check=True)
 result=json.loads(report.read_text());assert result['database']=='plm7_rebuild_qa_lifecycle'
 for key in ['dispatch_null_default_counters','first_revoke_then_rereport_returns_two_not_three','last_revoke_then_rereport_returns_two','own_project_and_global_fields','two_pieces_weight_6_28kg','non_penultimate_assembly_does_not_add_project','project_revoke_then_rereport','outer_transaction_rolls_back_business_and_summaries','real_shipment_list_summary_and_page_numeric_quantity']:assert result.get(key) is True,key
 shutil.copy2(report,ROOT.parent/'docs/production-monthly-database-verification.json');print(json.dumps(result,ensure_ascii=False,indent=2))
if __name__=='__main__':main()
