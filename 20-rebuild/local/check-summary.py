#!/usr/bin/env python3
"""Compile a test-only Spring database probe and run it on the disposable lifecycle QA clone."""
from pathlib import Path
import json,subprocess,shutil
from provision import ROOT
QA=ROOT/'runtime/lifecycle-qa';COMPOSE=QA/'compose.json'
def run(command,**kw):return subprocess.run(command,check=True,**kw)
def main():
 source=ROOT.parent/'backend/app/src/test/java/com/ljaps/rebuild/business/SummaryDatabaseProbe.java'
 (QA/'evidence/SummaryDatabaseProbe.java').write_text(source.read_text())
 report=QA/'evidence/summary-persistence-verification.json';report.unlink(missing_ok=True)
 command=['docker','compose','-f',str(COMPOSE),'run','--rm','-T','--no-deps','--name','ljaps-lifecycle-summary-probe','-e','LJAPS_LIFECYCLE_ENABLED=false','-e','LJAPS_LIFECYCLE_QA_RUN_ALL=false','-e','LJAPS_REGISTRATION_EVIDENCE=/evidence/summary-probe-registration.json','backend']
 log=QA/'summary-probe.log'
 with log.open('wb') as output:
  # Test class is outside /app/app.jar; the delivered application contains only production sources.
  run(command+['sh','-c',"javac -encoding UTF-8 -cp '/app/app.jar:/app/modules/*:/app/lib/*' -d /evidence /evidence/SummaryDatabaseProbe.java && exec java -Xms128m -Xmx768m -cp '/evidence:/app/app.jar:/app/modules/*:/app/lib/*' com.ljaps.rebuild.business.SummaryDatabaseProbe"],stdout=output,stderr=subprocess.STDOUT)
 result=json.loads(report.read_text());assert result['database']=='plm7_rebuild_qa_lifecycle'
 keys=['new_record_persisted','same_month_incremented_same_record','negative_delta_applied','same_product_different_type_separated','previous_month_unchanged','outer_transaction_rolled_back','area_query_matches_only_requested_monomer_active_rows','fixture_cleanup']
 assert all(result.get(key) is True for key in keys)
 shutil.copy2(report,ROOT.parent/'docs/summary-persistence-verification.json');print(json.dumps(result,ensure_ascii=False,indent=2))
if __name__=='__main__':main()
