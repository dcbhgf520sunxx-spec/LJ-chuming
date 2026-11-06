import { ref as h } from "vue";
import { resolveComponent as k } from "vue";
import { openBlock as t } from "vue";
import { createElementBlock as D } from "vue";
import { createElementVNode as u } from "vue";
import { createVNode as s } from "vue";
import { unref as e } from "vue";
import { withDirectives as R } from "vue";
import { createBlock as o } from "vue";
import { withCtx as l } from "vue";
import { createCommentVNode as n } from "vue";
import { createTextVNode as S } from "vue";
import { toDisplayString as E } from "vue";
import { Fragment as B } from "vue";
import { ElTableColumn as U } from "element-plus";
import { InfoFilled as V } from "@element-plus/icons-vue";
import { ElIcon as j } from "element-plus";
import { ElTooltip as F } from "element-plus";
import { vLoading as H } from "element-plus";
import { c as M, m as O } from "./module/form.vue.js";
import { cJ as T, x as A, f2 as m, o as I, i as L, G as P, an as $ } from "../../../../shared/runtime.js";
import q from "./module/header.vue.js";
const G = { class: "app-container" }, J = { style: { display: "inline-block" } }, Y = { __name: "index", setup(K) {
  const b = { add: true, edit: false, del: false, download: false }, _ = h(), g = h([["basicClass", ["parse-enum", T, { f: "L" }]]]), { CRUD: y, crud: d, columns: c } = A({ title: "配套件物料科目对照表", permission: { ...m }, invisibleColumns: [], crudApi: { ...M }, optShow: { ...b }, dataPath: "" }, _), { maxHeight: w } = I({ paginate: true });
  return y.HOOK.handleRefresh = (x, { data: i }) => {
    i == null || i.forEach((a) => {
      const f = a.mesAuxiliaryRelevancyClassDTOS.map((p) => p.classifyName);
      a.classifyNames = f.join(","), a.auxiliaryNames = a.auxiliaryNameList.join(",");
    });
  }, (x, i) => {
    const a = U, f = V, p = j, C = F, N = k("common-table"), v = H;
    return t(), D(B, null, [u("div", G, [s(e(q)), R((t(), o(N, { ref_key: "tableRef", ref: _, data: e(d).data, "data-format": g.value, "max-height": e(w), class: "hidden-table-check-all", style: { width: "100%" }, onSelectionChange: e(d).selectionChangeHandler }, { default: l(() => [s(a, { align: "center", label: "序号", type: "index", width: "60" }), e(c).visible("auxiliaryNames") ? (t(), o(a, { key: "auxiliaryNames", align: "left", label: "配套件名称", prop: "auxiliaryNames", width: "210" })) : n("", true), e(c).visible("accountingUnit") ? (t(), o(a, { key: "accountingUnit", align: "left", label: "配套件核算单位", prop: "accountingUnit", "show-overflow-tooltip": "", width: "120" })) : n("", true), e(c).visible("basicClass") ? (t(), o(a, { key: "basicClass", align: "left", label: "关联物料类型", prop: "basicClass", "show-overflow-tooltip": "", width: "120" })) : n("", true), e(c).visible("classifyNames") ? (t(), o(a, { key: "classifyNames", align: "left", label: "关联物料科目名称", prop: "classifyNames", "show-overflow-tooltip": "" })) : n("", true), e(c).visible("meteDiff") ? (t(), o(a, { key: "meteDiff", align: "left", label: "核算量误差值（%）", prop: "meteDiff", "show-overflow-tooltip": "" }, { header: l(() => [s(C, { content: "表示原材料出库量允许可超出清单量的范围", class: "item", effect: "light", placement: "top" }, { default: l(() => [u("div", J, [i[0] || (i[0] = u("span", null, "核算量误差值（%）", -1)), s(p, null, { default: l(() => [s(f)]), _: 1 })])]), _: 1 })]), default: l(({ row: { sourceRow: r } }) => [S(E(e(L)(r.meteDiff) ? `${r.meteDiff}%` : "-"), 1)]), _: 1 })) : n("", true), e(P)([...e(m).edit, ...e(m).del]) ? (t(), o(a, { key: 5, align: "center", fixed: "right", label: "操作", width: "180" }, { default: l(({ row: { sourceRow: r } }) => [s($, { data: { id: r.id }, permission: e(m), "show-del": "", "show-edit": "" }, null, 8, ["data", "permission"])]), _: 1 })) : n("", true)]), _: 1 }, 8, ["data", "data-format", "max-height", "onSelectionChange"])), [[v, e(d).loading]])]), s(O)], 64);
  };
} };
export {
  Y as default
};
