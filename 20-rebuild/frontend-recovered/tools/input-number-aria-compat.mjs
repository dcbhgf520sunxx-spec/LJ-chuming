import fs from 'node:fs';
import path from 'node:path';
import crypto from 'node:crypto';

const suffix = '/node_modules/element-plus/es/components/input-number/src/input-number.vue_vue_type_script_setup_true_lang.mjs';
const expectedVersion = '2.14.7';
const expectedSHA256 = '208827252f56987dcbb187820d86065c15a2beabf940f01e7799c000aa98bf7c';
const hash = value => crypto.createHash('sha256').update(value).digest('hex');
const original = '\t\tonUpdated(() => {\n\t\t\t(input.value?.input)?.setAttribute("aria-valuenow", `${data.currentValue ?? ""}`);\n\t\t});';
const replacement = original.replace('\n\t\t});', '\n\t\t\tconst innerInput = input.value?.input;\n\t\t\tinnerInput?.setAttribute("aria-disabled", String(innerInput.disabled));\n\t\t});');

export function transformInputNumberAria(code, id, version) {
  const cleanId = id.split('?')[0].replaceAll('\\', '/');
  if (!cleanId.endsWith(suffix)) return null;
  if (version !== expectedVersion || hash(code) !== expectedSHA256 || code.split(original).length !== 2) {
    throw new Error('InputNumber ARIA compatibility source/version changed; review before rebuilding');
  }
  return code.replace(original, replacement);
}

function transformFile(code, id) {
  const cleanId = id.split('?')[0].replaceAll('\\', '/');
  if (!cleanId.endsWith(suffix)) return null;
  const packageFile = cleanId.slice(0, -suffix.length) + '/node_modules/element-plus/package.json';
  return transformInputNumberAria(code, cleanId, JSON.parse(fs.readFileSync(packageFile, 'utf8')).version);
}

export function inputNumberAriaCompatibility() {
  const name = 'input-number-dynamic-aria-disabled-' + hash(expectedVersion + expectedSHA256 + replacement).slice(0, 12);
  return {
    name,
    enforce: 'pre',
    configResolved(config) { inputNumberAriaEvidence(config.root); },
    config: () => ({ optimizeDeps: { esbuildOptions: { plugins: [{
      name,
      setup(build) {
        build.onLoad({ filter: /\/node_modules\/element-plus\/es\/components\/input-number\/src\/input-number\.vue_vue_type_script_setup_true_lang\.mjs$/ }, args => {
          const code = transformFile(fs.readFileSync(args.path, 'utf8'), args.path);
          return { contents: code, loader: 'js', resolveDir: path.dirname(args.path) };
        });
      }
    }] } } }),
    transform(code, id) {
      const transformed = transformFile(code, id);
      return transformed === null ? null : { code: transformed, map: null };
    }
  };
}

export function inputNumberAriaEvidence(project) {
  const source = path.join(project, suffix.slice(1));
  const before = fs.readFileSync(source, 'utf8');
  const version = JSON.parse(fs.readFileSync(path.join(project, 'node_modules/element-plus/package.json'), 'utf8')).version;
  const after = transformInputNumberAria(before, source, version);
  return { dependency: 'element-plus', version, path: suffix.slice(1), before_sha256: hash(before), after_sha256: hash(after), production_and_dev_optimizer_use_same_transform: true };
}
