import { ref as l } from "vue";
import { resolveComponent as d } from "vue";
import { openBlock as f } from "vue";
import { createElementBlock as U } from "vue";
import { createVNode as e } from "vue";
import { withCtx as i } from "vue";
import { withDirectives as $ } from "vue";
import { createBlock as _ } from "vue";
import { unref as o } from "vue";
import { createTextVNode as b } from "vue";
import { toDisplayString as J } from "vue";
import { createCommentVNode as M } from "vue";
import { isRef as O } from "vue";
import { Fragment as G } from "vue";
import { ElTableColumn as K } from "element-plus";
import { ElTag as Q } from "element-plus";
import { ElPagination as W } from "element-plus";
import { vLoading as X } from "element-plus";
import { a as Y, _ as Z } from "./import-dialog.vue.js";
import { u as ee, J as te, o as oe, iE as y } from "../../../../shared/runtime.js";
const ie = { __name: "not-archived-list-drawer", props: { modelValue: { type: Boolean, require: true } }, emits: ["update:modelValue", "success"], setup(x, { emit: C }) {
  const V = x, k = l([["endDate", ["parse-time", "{y}-{m}-{d} {h}:{i}"]]]), h = C, g = l([]), p = l(false), u = l(false), w = l({}), v = l(false), { visible: s, handleClose: D } = ee({ emit: h, props: V, showHook: m, closeHook: S }), { handleSizeChange: T, handleCurrentChange: z, total: N, setTotalPage: B, queryPage: c } = te({ fetchHook: m }), E = l(), { maxHeight: P } = oe({ mainBox: ".not-archived-list-drawer", extraBox: ".el-drawer__header", wrapperBox: ".el-drawer__body", paginate: true }, s);
  function S() {
    v.value && h("success");
  }
  async function m() {
    try {
      p.value = true;
      const { content: r = [], totalElements: n } = await Y({ isArchivist: 0, ...c });
      g.value = r, B(n);
    } catch (r) {
      console.log(r);
    } finally {
      p.value = false;
    }
  }
  function R() {
    c.pageNumber = 1, v.value = true, m();
  }
  function H(r) {
    w.value = r, u.value = true;
  }
  return (r, n) => {
    const t = K, I = Q, j = d("common-button"), L = d("common-table"), q = W, A = d("common-drawer"), F = X;
    return f(), U(G, null, [e(A, { "append-to-body": "", ref_key: "drawerRef", ref: E, modelValue: o(s), "onUpdate:modelValue": n[0] || (n[0] = (a) => O(s) ? s.value = a : null), top: "10vh", width: "600px", "before-close": o(D), title: "合同归档提示", "wrapper-closable": false, size: "60%", "custom-class": "not-archived-list-drawer" }, { content: i(() => [$((f(), _(L, { "data-format": k.value, ref: "tableRef", data: g.value, "max-height": o(P), style: { width: "100%" } }, { default: i(() => [e(t, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), e(t, { prop: "oaNumber", "show-overflow-tooltip": true, label: "OA编号", align: "center", "min-width": "120px" }), e(t, { prop: "contractDefinitionType", "show-overflow-tooltip": true, label: "合同类型", align: "center", width: "100px" }, { default: i(({ row: { sourceRow: a } }) => [a.contractDefinitionType ? (f(), _(I, { key: 0, effect: "plain", type: o(y).V[a.contractDefinitionType].T }, { default: i(() => [b(J(o(y).VL[a.contractDefinitionType]), 1)]), _: 2 }, 1032, ["type"])) : M("", true)]), _: 1 }), e(t, { prop: "serialNumber", "show-overflow-tooltip": true, label: "合同编号", align: "center", "min-width": "120px" }), e(t, { prop: "name", "show-overflow-tooltip": true, label: "合同名称", align: "center", "min-width": "120px" }), e(t, { prop: "firstParty", "show-overflow-tooltip": true, label: "甲方", align: "center", "min-width": "120px" }), e(t, { prop: "secondParty", "show-overflow-tooltip": true, label: "乙方", align: "center", "min-width": "120px" }), e(t, { prop: "contractCreatorName", "show-overflow-tooltip": true, label: "创建人", align: "center", width: "120px" }), e(t, { prop: "endDate", "show-overflow-tooltip": true, label: "审批终结日期", align: "center", width: "110px" }), e(t, { label: "操作", width: "80", align: "center" }, { default: i(({ row: a }) => [e(j, { type: "primary", size: "small", onClick: (ae) => H(a) }, { default: i(() => n[2] || (n[2] = [b("导入")])), _: 2, __: [2] }, 1032, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data-format", "data", "max-height"])), [[F, p.value]]), e(q, { total: o(N), "current-page": o(c).pageNumber, "page-size": o(c).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: o(T), onCurrentChange: o(z) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])]), _: 1 }, 8, ["modelValue", "before-close"]), e(Z, { visible: u.value, "onUpdate:visible": n[1] || (n[1] = (a) => u.value = a), projectInfo: w.value, onSuccess: R }, null, 8, ["visible", "projectInfo"])], 64);
  };
} };
export {
  ie as default
};
