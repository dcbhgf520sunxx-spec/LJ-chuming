import importlib.util,json,stat,tempfile,unittest
from pathlib import Path
from unittest.mock import patch
spec=importlib.util.spec_from_file_location('init_config',Path(__file__).with_name('init-config.py'));init=importlib.util.module_from_spec(spec);spec.loader.exec_module(init)
class InitialUserPassword(unittest.TestCase):
 def test_existing_secrets_are_preserved_and_initial_password_is_stable(self):
  with tempfile.TemporaryDirectory() as folder:
   root=Path(folder);(root/'runtime').mkdir();(root/'runtime/rsa-private.pem').write_text('test');(root/'runtime/rsa-public.pem').write_text('test')
   env=root/'.env';env.write_text('LJAPS_JWT_SECRET=preserve-me\nLJAPS_DB_PASSWORD=also-preserve\n')
   with patch.object(init,'ROOT',root):init.main();first=env.read_text();init.main()
   values=dict(line.split('=',1) for line in first.splitlines() if '=' in line)
   self.assertGreaterEqual(len(values.get('LJAPS_INITIAL_USER_PASSWORD','')),32);self.assertEqual(values['LJAPS_JWT_SECRET'],'preserve-me');self.assertEqual(values['LJAPS_DB_PASSWORD'],'also-preserve');self.assertEqual(env.read_text(),first);self.assertEqual(stat.S_IMODE(env.stat().st_mode),0o600)
 def test_compose_requires_private_initial_password(self):
  c=json.loads(Path(__file__).with_name('compose.json').read_text());self.assertIn('LJAPS_INITIAL_USER_PASSWORD',c['services']['backend']['environment'])
if __name__=='__main__':unittest.main()
