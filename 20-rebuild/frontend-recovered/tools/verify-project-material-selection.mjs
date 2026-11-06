import fs from 'node:fs';
import path from 'node:path';
import vm from 'node:vm';
import assert from 'node:assert/strict';
import { fileURLToPath } from 'node:url';
import { parse } from '@babel/parser';
import * as Vue from 'vue';
import useUtils from '../node_modules/element-plus/es/components/table/src/table/utils-helper.mjs';
import useCurrent from '../node_modules/element-plus/es/components/table/src/store/current.mjs';
import TableFooter from '../node_modules/element-plus/es/components/table/src/table-footer/index.mjs';

const root = path.resolve(path.dirname(fileURLToPath(import.meta.url)), '..');
const pagePath = 'src/views/mes/production-manage/dashboard/project-material/index.vue.js';
const source = fs.readFileSync(path.join(root, pagePath), 'utf8');
const parsed = parse(source, { sourceType: 'module' });
const declaration = parsed.program.body.find(n => n.type === 'VariableDeclaration' && n.declarations.some(d => d.id.name === 'ee'));
const setup = declaration.declarations.find(d => d.id.name === 'ee').init.properties.find(p => p.key.name === 'setup');
const render = setup.body.body.find(n => n.type === 'ReturnStatement');
const imports = {};
for (const item of parsed.program.body) {
  if (item.type === 'ImportDeclaration' && item.source.value === 'vue') {
    for (const spec of item.specifiers) imports[spec.local.name] = Vue[spec.imported.name];
  }
}
const setupBody = source.slice(setup.body.start + 1, render.start) + 'return { load: C, selectRow: E, selectTotal: W, table: x, data: w, selected: h, loading: f };';
const wrap = fs.readFileSync(path.join(root, 'src/shared/segments/061.fragment.js'), 'utf8');
assert.match(wrap, /setCurrentRow: q/);
assert.match(wrap, /r\.value\.setCurrentRow\(Ue\)/);
assert.match(wrap, /\$el: Ee\(/);
assert.equal(source.includes('document.querySelector'), false);
assert.equal(source.includes('.addClass('), false);

// Execute the actual installed Element Plus single-selection hooks in a Vue component.
let selection;
const renderer = Vue.createRenderer({
  createElement: type => ({ type }), createComment: () => ({}), createText: text => ({ text }),
  insert() {}, remove() {}, setText() {}, setElementText() {}, patchProp() {}, parentNode() {}, nextSibling() {}
});
const app = renderer.createApp({ setup() {
  const current = useCurrent({ data: Vue.ref([]), rowKey: Vue.ref(null) });
  const utils = useUtils({ commit(name, row) {
    assert.equal(name, 'setCurrentRow');
    current.updateCurrentRow(row);
  } });
  selection = { ...utils, state: current.states.currentRow };
  return () => Vue.h('div');
} });
app.mount({});

// The real installed footer renders tfoot > tr, not a jQuery wrapper or tbody.
const footerVNode = TableFooter.render.call({
  columns: [{ property: 'quantity' }], getCellStyles: () => ({}), getCellClasses: () => '',
  summaryMethod: () => ['合计'], store: { states: { data: Vue.ref([]) } }
});
assert.equal(footerVNode.type, 'tfoot');
assert.equal(footerVNode.children[0].type, 'tr');

let cases = 3;
let rows = [{ productClassificationEnum: 8, steelSpec: '8', material: 'Q235B' }];
let allowed = true, failure = false, calls = 0;
const provided = new Map();
const context = {
  ...imports, d: (key, value) => provided.set(key, value), H: () => ({ globalProjectId: Vue.ref(3) }),
  L: () => ({ maxHeight: Vue.ref(600) }), A: () => allowed, J: { get: 'material_analysis:get' },
  Q: async () => { calls++; if (failure) throw Error('read unavailable'); return { content: rows }; }
};
const page = vm.runInNewContext('(function(){' + setupBody + '})()', context);
const classes = new Set();
const footer = { classList: { add: name => classes.add(name), remove: name => classes.delete(name) } };
const queries = [];
page.table.value = {
  $el: { querySelector(selector) { queries.push(selector); assert.equal(selector, '.el-table__footer-wrapper tr'); return footer; } },
  setCurrentRow: selection.setCurrentRow
};
const selectedKinds = [];
const stop = Vue.watch(provided.get('currentRow'), row => selectedKinds.push(row.title || row.steelSpec), { flush: 'sync' });
await page.load({ projectId: 3 });
assert.equal(page.selected.value.title, '合计');
assert(classes.has('current-row'));
assert.equal(typeof footer.onclick, 'function');
assert.equal(selectedKinds.at(-1), '合计');
assert.equal(page.loading.value, false);
cases++;

selection.setCurrentRow(rows[0]);
page.selectRow(rows[0]);
assert.equal(page.selected.value.steelSpec, '8');
assert.equal(classes.has('current-row'), false);
assert.equal(selection.state.value.steelSpec, '8');
cases++;
footer.onclick();
assert.equal(selection.state.value, null);
assert.equal(page.selected.value.title, '合计');
assert(classes.has('current-row'));
cases++;

// Changing project/workshop/classification runs the same reload, selecting a fresh total.
for (const query of [{ projectId: 4 }, { projectId: 4, workShopId: 1 }, { projectId: 4, productClassificationEnum: 16 }]) {
  page.selectRow(rows[0]);
  const oldTotal = page.selected.value;
  rows = [{ productClassificationEnum: 16, steelSpec: 'H100', material: 'Q355' }];
  await page.load(query);
  assert.equal(page.data.value[0].steelSpec, 'H100');
  assert.equal(page.selected.value.title, '合计');
  assert.notEqual(page.selected.value, oldTotal);
  assert(classes.has('current-row'));
  cases++;
}
rows = [];
await page.load({ projectId: 0 });
assert.equal(Object.keys(page.selected.value).length, 0);
assert.equal(classes.has('current-row'), false);
cases++;

// No permission does not issue a read; read errors still clear the loading indicator.
allowed = false;
const before = calls;
await page.load({ projectId: 3 });
assert.equal(calls, before);
cases++;
allowed = true; failure = true;
await assert.rejects(page.load({ projectId: 3 }), /read unavailable/);
assert.equal(page.loading.value, false);
cases++;

// Missing/unmounted footer is harmless without suppressing unrelated errors.
failure = false; rows = [{ steelSpec: 'H200' }];
page.table.value = undefined;
await page.load({ projectId: 3 });
assert.equal(page.selected.value.title, '合计');
cases++;
stop(); app.unmount();
const result = { cases, failed: 0, source: pagePath, actual_vue_reactivity: true,
  actual_element_plus_version: JSON.parse(fs.readFileSync(path.join(root, 'node_modules/element-plus/package.json'))).version,
  actual_element_plus_current_row_hooks: true, actual_element_plus_footer_vnode: true,
  doubles: ['HTTP response', 'common-table DOM host/classList'], qa_http_calls: 0,
  actual_browser_regression: 'pending parent unified build and browser readback' };
fs.writeFileSync(path.join(root, 'project-material-selection-verification.json'), JSON.stringify(result, null, 2) + '\n');
console.log(JSON.stringify(result, null, 2));
