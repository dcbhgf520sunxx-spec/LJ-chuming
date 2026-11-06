#!/usr/bin/env python3
"""Run source-only monthly-production probe against the isolated QA clone; all fixtures roll back."""
from pathlib import Path
import json,subprocess,shutil
from provision import ROOT
QA=ROOT/'runtime/lifecycle-qa';COMPOSE=QA/'compose.json'
def main():
 name='InnerSettlementDatabaseProbe';source=ROOT.parent/'backend/app/src/test/java/com/ljaps/rebuild/business'/f'{name}.java'
 (QA/'evidence'/source.name).write_text(source.read_text());report=QA/'evidence/inner-settlement-database-verification.json';report.unlink(missing_ok=True)
 command=['docker','compose','-f',str(COMPOSE),'run','--rm','-T','--no-deps','--name','ljaps-lifecycle-inner-settlement-probe','-e','LJAPS_LIFECYCLE_ENABLED=false','-e','LJAPS_LIFECYCLE_QA_RUN_ALL=false','-e','LJAPS_REGISTRATION_EVIDENCE=/evidence/inner-settlement-registration.json','backend','sh','-c',f"javac -encoding UTF-8 -cp '/app/app.jar:/app/modules/*:/app/lib/*' -d /evidence /evidence/{name}.java && exec java -Xms128m -Xmx768m -cp '/evidence:/app/app.jar:/app/modules/*:/app/lib/*' com.ljaps.rebuild.business.{name}"]
 with (QA/'inner-settlement-probe.log').open('wb') as output:subprocess.run(command,stdout=output,stderr=subprocess.STDOUT,check=True)
 result=json.loads(report.read_text());assert result['database']=='plm7_rebuild_qa_lifecycle'
 for key in ['exact_original_get_and_nested_draft_payload','forged_project_supplier_manager_serial_rejected','legacy_multi_project_and_csv_substring_rejected','supplier_order_class_and_filing_date_restored','authenticated_actor_not_browser_actor','oa_hidden_draft_without_approval_or_payment','outer_rollback_restores_drafts_and_fixtures','original_oa_preview_reads_owned_hidden_draft','hidden_preview_no_permission_and_other_creator_rejected']:assert result.get(key) is True,key
 shutil.copy2(report,ROOT.parent/'docs/inner-settlement-database-verification.json');print(json.dumps(result,ensure_ascii=False,indent=2))
if __name__=='__main__':main()
