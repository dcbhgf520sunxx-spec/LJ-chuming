// Execute the complete current jx.setup with installed Vue ref/watchEffect.
// API data and inject are controlled; no HTTP, DOM or browser-pass claim.
import fs from 'node:fs';
import path from 'node:path';
import vm from 'node:vm';
import crypto from 'node:crypto';
import assert from 'node:assert/strict';
import { parse } from '@babel/parser';
import { ref, watchEffect, nextTick } from 'vue';

const root = path.resolve(import.meta.dirname, '..');
const file = 'src/shared/segments/045.fragment.js';
const source = fs.readFileSync(path.join(root, file), 'utf8');
const ast = parse(source, { sourceType: 'module' });
const declaration = ast.program.body.find(n => n.type === 'VariableDeclaration' && n.declarations.some(d => d.id.name === 'jx'));
const component = declaration.declarations.find(d => d.id.name === 'jx').init;
assert.equal(component.properties.find(p => p.key.name === '__name').value.value, 'outsource-form');
const expression = '(' + source.slice(component.start, component.end) + ')';
const checks = [];
const settle = async () => { await nextTick(); await new Promise(resolve => setImmediate(resolve)); };

async function scenario(id, initial, verify, provider = async ({ projectId }) => [{ id: projectId * 10, name: '原生批次形状' }]) {
  const refs = [], calls = [], errors = [], stops = [];
  const listener = error => errors.push({ name: error.name, message: error.message, stack: String(error.stack) });
  process.on('unhandledRejection', listener);
  const form = { projectId: initial, areaBatchId: 99, quantity: 2, remark: '保留原表单' };
  let failure;
  const context = {
    Z: value => { const result = ref(value); refs.push(result); return result; },
    Dt: fn => { const stop = watchEffect(fn); stops.push(stop); return stop; },
    ft: key => { assert.equal(key, 'maxQuantity'); return ref(7); },
    rd: async query => { calls.push(structuredClone(query)); return provider(query); },
  };
  try {
    const render = vm.runInNewContext(expression, context, { filename: file }).setup({ form, material: {} });
    assert.equal(typeof render, 'function');
    await settle();
    await verify({ refs, calls, errors, form });
  } catch (error) {
    failure = { name: error.name, message: error.message };
  } finally {
    for (const stop of stops) stop();
    await settle();
    process.removeListener('unhandledRejection', listener);
  }
  checks.push({ id, status: failure ? 'fail' : 'passed', actual: { calls, errors, currentProjectId: refs[0]?.value.projectId, areaBatchId: refs[0]?.value.areaBatchId, batchOptions: refs[1]?.value }, ...(failure ? { failure } : {}) });
}

await scenario('outsource_form_undefined_project_setup_preserves_control_without_batch_fetch', undefined, ({ calls, errors, refs }) => {
  assert.deepEqual(calls, []);
  assert.deepEqual(errors, []);
  assert.equal(refs[1].value.length, 0);
  assert.equal(refs[0].value.areaBatchId, 99);
  assert.equal(refs[0].value.quantity, 2);
  assert.equal(refs[0].value.remark, '保留原表单');
});

await scenario('outsource_form_initial_project1_fetches_batches_without_uninitialized_ref', 1, ({ calls, errors, refs }) => {
  assert.deepEqual(errors, []);
  assert.deepEqual(calls, [{ projectId: 1 }]);
  assert.equal(refs[0].value.areaBatchId, undefined);
  assert.deepEqual(Array.from(refs[1].value, x => x.id), [10]);
  assert.equal(refs[0].value.quantity, 2);
});

let release;
await scenario('outsource_form_initial_project1_pending_request_clears_old_batch_then_loads', 1, async ({ calls, errors, refs }) => {
  try {
    assert.deepEqual(errors, []);
    assert.deepEqual(calls, [{ projectId: 1 }]);
    assert.equal(refs[0].value.areaBatchId, undefined);
    assert.equal(refs[1].value.length, 0);
  } finally {
    // Always resolve the test provider, including on RED, before removing the
    // rejection listener or proceeding to another real Vue watchEffect.
    if (release) release([{ id: 21, name: '延迟批次' }]);
  }
  await settle();
  assert.deepEqual(Array.from(refs[1].value, x => x.id), [21]);
}, () => new Promise(resolve => { release = resolve; }));

await scenario('outsource_form_later_project_selection_retains_real_vue_watch_behavior', undefined, async ({ calls, errors, refs }) => {
  refs[0].value.projectId = 1;
  await settle();
  assert.deepEqual(errors, []);
  assert.deepEqual(calls, [{ projectId: 1 }]);
  assert.deepEqual(Array.from(refs[1].value, x => x.id), [10]);
  assert.equal(refs[0].value.areaBatchId, undefined);
});

await scenario('outsource_form_initial_project_then_reselection_fetches_current_project_batches', 1, async ({ calls, errors, refs }) => {
  refs[0].value.areaBatchId = 123;
  refs[0].value.projectId = 2;
  await settle();
  assert.deepEqual(errors, []);
  assert.deepEqual(calls, [{ projectId: 1 }, { projectId: 2 }]);
  assert.deepEqual(Array.from(refs[1].value, x => x.id), [20]);
  assert.equal(refs[0].value.areaBatchId, undefined);
});

const report = {
  verified_at: new Date().toISOString(),
  kind: 'actual_complete_setup_with_installed_vue_watchEffect',
  source_proof: [{ path: file, sha256: crypto.createHash('sha256').update(source).digest('hex'), component: 'jx', setup_line: 1 }],
  checks, cases: checks.length, passed: checks.filter(c => c.status === 'passed').length, failed: checks.filter(c => c.status === 'fail').length,
  HTTP_calls: 0, browser_verified: false,
  scope: 'Current shared outsource form setup, immediate initial-project callback and later Vue reactive project selection. Only provider/inject controlled; real setup/ref/watchEffect executed.',
};
fs.writeFileSync(path.join(root, 'outsource-form-initialization-verification.json'), JSON.stringify(report, null, 2) + '\n');
console.log(JSON.stringify({ report: 'outsource-form-initialization-verification.json', cases: report.cases, passed: report.passed, failed: report.failed, HTTP_calls: 0 }));
if (report.failed) throw new Error(report.failed + ' actual outsource setup initialization regressions');
