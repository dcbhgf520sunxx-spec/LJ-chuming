#!/usr/bin/env python3
"""Run source-only monthly-production probe against the isolated QA clone; all fixtures roll back."""
from pathlib import Path
import json,subprocess,shutil
from provision import ROOT
QA=ROOT/'runtime/lifecycle-qa';COMPOSE=QA/'compose.json'
def main():
 name='ProductionCarryDatabaseProbe';source=ROOT.parent/'backend/app/src/test/java/com/ljaps/rebuild/business'/f'{name}.java'
 (QA/'evidence'/source.name).write_text(source.read_text());report=QA/'evidence/production-carry-database-verification.json';report.unlink(missing_ok=True)
 command=['docker','compose','-f',str(COMPOSE),'run','--rm','-T','--no-deps','--name','ljaps-lifecycle-production-carry-probe','-e','LJAPS_LIFECYCLE_ENABLED=false','-e','LJAPS_LIFECYCLE_QA_RUN_ALL=false','-e','LJAPS_REGISTRATION_EVIDENCE=/evidence/production-carry-registration.json','backend','sh','-c',f"javac -encoding UTF-8 -cp '/app/app.jar:/app/modules/*:/app/lib/*' -d /evidence /evidence/{name}.java && exec java -Xms128m -Xmx768m -cp '/evidence:/app/app.jar:/app/modules/*:/app/lib/*' com.ljaps.rebuild.business.{name}"]
 with (QA/'production-carry-probe.log').open('wb') as output:subprocess.run(command,stdout=output,stderr=subprocess.STDOUT,check=True)
 result=json.loads(report.read_text());assert result['database']=='plm7_rebuild_qa_lifecycle'
 for key in ['ambiguous_opening_rejected_and_all_carry_changes_rolled_back','new_current_month_row_uses_original_formula','existing_new_month_task_complete_preserved_and_inproduction_added','same_product_different_type_isolated','previous_month_records_unchanged','same_period_repeated_without_double_carry','failed_period_retry_then_succeeded','fixture_cleanup']:assert result.get(key) is True,key
 shutil.copy2(report,ROOT.parent/'docs/production-carry-database-verification.json');print(json.dumps(result,ensure_ascii=False,indent=2))
if __name__=='__main__':main()
