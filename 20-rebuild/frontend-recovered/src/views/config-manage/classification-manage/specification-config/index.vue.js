import { useStore as W } from "vuex";
import { computed as w } from "vue";
import { watch as q } from "vue";
import { ref as d } from "vue";
import { reactive as G } from "vue";
import { provide as X } from "vue";
import { resolveComponent as Y } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as b } from "vue";
import { createElementVNode as o } from "vue";
import { createVNode as c } from "vue";
import { normalizeStyle as B } from "vue";
import { unref as i } from "vue";
import { withDirectives as F } from "vue";
import { createBlock as k } from "vue";
import { withCtx as v } from "vue";
import { toDisplayString as O } from "vue";
import { createCommentVNode as R } from "vue";
import { Fragment as Z } from "vue";
import { renderList as ee } from "vue";
import { createTextVNode as U } from "vue";
import * as te from "lodash";
import { nextTick as ae } from "vue";
import { ElInput as se } from "element-plus";
import { ElTree as le } from "element-plus";
import { ElTag as oe } from "element-plus";
import { ElTableColumn as re } from "element-plus";
import { ElCard as ie } from "element-plus";
import { vLoading as ne } from "element-plus";
import { c as de } from "../../../../modules/specification-config-4ae0bc64.js";
import { _ as ce, x as ue, d6 as fe, o as pe, an as me, d7 as _e, i as he } from "../../../../shared/runtime.js";
import ve from "./module/header.vue.js";
import ge from "./module/form.vue.js";
import "../../../../modules/use-table-operate-4f84437f.js";
const ye = (N, M = false) => {
  const a = W(), p = w(() => a.state.config.loaded.matClsTree);
  if ((!p.value || M) && (a.commit("config/SET_LOADED", { key: "matClsTree", loaded: false }), a.dispatch("config/fetchMatClsTree")), N) {
    const S = q(p, (g) => {
      g && setTimeout(() => {
        N(), S();
      }, 0);
    }, { immediate: true });
  }
  return { rawMatClsTree: w(() => a.state.config.rawMatClsTree), manufClsTree: w(() => a.state.config.manufClsTree), matClsTree: w(() => a.state.config.matClsTree), loaded: p };
};
const xe = { class: "app-container wrap" }, Ce = { class: "wrap-left" }, Te = { class: "head-container" }, we = { style: { padding: "3px 5px", "border-radius": "3px", width: "100%" } }, be = { style: { "font-weight": "bold" } }, ke = { key: 0, style: { float: "right", padding: "0 2px 0 6px" } }, Ne = { class: "wrap-right" }, Me = { class: "card-wrap" }, Se = { class: "clearfix" }, Ve = { style: { "line-height": "29px" } }, De = { class: "card-box" }, Ee = { __name: "index", setup(N) {
  const M = { add: true, edit: false, del: false, download: false }, { crud: a, CRUD: p } = ue({ title: "规格配置", optShow: { ...M }, permission: { ...fe }, requiredQuery: ["id"], crudApi: { ...de }, hasPagination: false }), { maxHeight: S, heightStyle: g } = pe({ extraHeight: 15 }), { loaded: P, rawMatClsTree: I } = ye(Q, true), y = d(), V = d(), u = d(), m = d(), D = d(), E = d([]), L = d({}), J = { children: "children", label: "name" }, K = G({ clsTree: true });
  X("currentNode", L), q(V, (e) => {
    y.value.filter(e);
  });
  async function Q() {
    try {
      E.value = te.cloneDeep(I.value);
      const e = _e(E.value);
      z(e), ae(() => {
        y.value.setCurrentKey(e.id, true);
      });
    } catch (e) {
      console.log("科目规格配置-拉取物料分类树", e);
    } finally {
      K.clsTree = false;
    }
  }
  function $(e, t, n) {
    var x, C;
    if (!e) return true;
    let l = n.parent, _ = [t.name, t.serialNumber], h = 1;
    for (; h < n.level; ) _ = [..._, (x = l == null ? void 0 : l.data) == null ? void 0 : x.name, (C = l == null ? void 0 : l.data) == null ? void 0 : C.serialNumber], l = l.parent, h++;
    return _.some((T) => T.indexOf(e) !== -1);
  }
  function z(e) {
    u.value = void 0, e.isLeaf ? (L.value = e, a.query.id = e.id, a.toQuery()) : y.value.setCurrentKey(L.value.id, true);
  }
  function j(e, t) {
    u.value.length || A(e, t), t || (m.value = D.value, u.value && he(m.value) && (m.value = m.value.filter((n) => n.value.includes(u.value)), a.data[t].list = m.value));
  }
  function A(e, t) {
    t || (a.data[t].list = D.value);
  }
  return p.HOOK.afterRefresh = (e, t) => {
    D.value = JSON.parse(JSON.stringify(e.data[0].list));
  }, (e, t) => {
    const n = se, l = le, _ = oe, h = re, x = Y("common-table"), C = ie, T = ne;
    return r(), b("div", xe, [o("div", Ce, [o("div", Te, [c(n, { modelValue: V.value, "onUpdate:modelValue": t[0] || (t[0] = (s) => V.value = s), modelModifiers: { trim: true }, size: "default", clearable: "", placeholder: "输入科目名称、编码搜索" }, null, 8, ["modelValue"])]), o("div", { style: B(i(g)) }, [F((r(), k(l, { ref_key: "treeMenuRef", ref: y, data: E.value, "filter-node-method": $, props: J, "default-expand-all": "", "expand-on-click-node": "", "highlight-current": "", "node-key": "id", style: { height: "100%" }, onNodeClick: z }, { default: v(({ node: s, data: f }) => [o("div", we, [o("span", be, O(s.label), 1), f.isLeaf ? (r(), b("span", ke, [o("span", null, O(f.serialNumber), 1)])) : R("", true)])]), _: 1 }, 8, ["data"])), [[T, !i(P) && K.clsTree]])], 4)]), o("div", Ne, [c(i(ve), { id: "header", ref: "header" }, null, 512), F((r(), b("div", Me, [(r(true), b(Z, null, ee(i(a).data, (s, f) => (r(), k(C, { key: s.id, style: B(i(g)) }, { header: v(() => [o("div", Se, [o("span", Ve, [U(O(s.name) + " ", 1), s.boolWeightedAverage ? (r(), k(_, { key: 0, type: "success", effect: "plain", size: "default" }, { default: v(() => t[2] || (t[2] = [U("加权")])), _: 1, __: [2] })) : R("", true)]), c(me, { data: s, style: { float: "right" } }, null, 8, ["data"])])]), default: v(() => [o("div", De, [f === 0 ? (r(), k(n, { key: 0, modelValue: u.value, "onUpdate:modelValue": t[1] || (t[1] = (H) => u.value = H), modelModifiers: { trim: true }, class: "input-underline", clearable: "", placeholder: "输入规格搜索", size: "default", style: { width: "240px", "margin-bottom": "5px" }, onClear: (H) => A(s.list, f), onKeyup: (H) => j(s.list, f) }, null, 8, ["modelValue", "onClear", "onKeyup"])) : R("", true), c(x, { data: s.list, maxHeight: i(S) - 150, "show-empty-symbol": false, "return-source-data": "", "row-key": "id" }, { default: v(() => [c(h, { align: "left", label: "编码", prop: "code", width: "80" }), c(h, { label: "规格", "min-width": "140", prop: "value" })]), _: 2 }, 1032, ["data", "maxHeight"])])]), _: 2 }, 1032, ["style"]))), 128))])), [[T, i(a).loading]])]), c(i(ge))]);
  };
} }, Be = ce(Ee, [["__scopeId", "data-v-9887e9f0"]]);
export {
  Be as default
};
