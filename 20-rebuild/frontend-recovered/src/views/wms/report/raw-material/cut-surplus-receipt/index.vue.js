import { ref as m } from "vue";
import { resolveComponent as y } from "vue";
import { openBlock as t } from "vue";
import { createElementBlock as S } from "vue";
import { createVNode as i } from "vue";
import { unref as e } from "vue";
import { withDirectives as x } from "vue";
import { createBlock as a } from "vue";
import { withCtx as u } from "vue";
import { createCommentVNode as l } from "vue";
import { createTextVNode as T } from "vue";
import { toDisplayString as f } from "vue";
import { createElementVNode as E } from "vue";
import { ElTableColumn as N } from "element-plus";
import { vLoading as R } from "element-plus";
import { l as w, jX as j, cJ as V, x as B, BE as D, o as M, i as P, BF as p, br as h, k6 as A, P as I } from "../../../../../shared/runtime.js";
import L from "./module/header.vue.js";
function O(n) {
  return w({ module: "wms", url: "report/raw-materials/outbound/cut-surplus", method: "get", params: n });
}
function $(n) {
  return w({ module: "wms", url: `report/raw-materials/inbound/receipt/${n}`, method: "get" });
}
const F = { class: "app-container" }, z = { __name: "index", setup(n) {
  const b = { add: false, edit: false, del: false, download: false }, g = m([...j, ["cutEndTime", "parse-time"], ["basicClass", ["parse-enum", V, { bit: true, split: " | " }]]]), d = m(), { crud: c, columns: r } = B({ title: "切割余料表", sort: ["id.desc"], permission: { ...D }, optShow: { ...b }, crudApi: { get: O, detail: $ } }, d), { maxHeight: _ } = M({ paginate: true });
  return (H, q) => {
    const o = N, v = y("common-table"), k = R;
    return t(), S("div", F, [i(e(L)), x((t(), a(v, { ref_key: "tableRef", ref: d, data: e(c).data, "data-format": g.value, "default-expand-all": false, "max-height": e(_), "highlight-current-row": "", "row-key": "id", onSortChange: e(c).handleSortChange }, { default: u(() => [i(o, { align: "center", label: "序号", type: "index", width: "60" }, { default: u(({ row: s, $index: C }) => [e(P)(s.rejectStatus) && s.rejectStatus !== e(p).NONE.V ? (t(), a(h, { key: 0, color: e(p).V[s.rejectStatus].COLOR, name: e(p).VL[s.rejectStatus] }, null, 8, ["color", "name"])) : l("", true), T(" " + f(C + 1), 1)]), _: 1 }), e(r).visible("cutTaskId") ? (t(), a(o, { key: "cutTaskId", "show-overflow-tooltip": true, label: "套料工单", prop: "cutTaskId", width: "175" }, { default: u(({ row: s }) => [i(h, { offset: 10, show: !!s.boolPartyA, name: "甲供", type: "partyA" }, null, 8, ["show"]), E("span", null, f(s.cutTaskId), 1)]), _: 1 })) : l("", true), e(r).visible("classifyName") ? (t(), a(o, { key: "classifyName", "show-overflow-tooltip": true, align: "left", label: "名称", prop: "classifyName", width: "120" })) : l("", true), e(r).visible("basicClass") ? (t(), a(o, { key: "basicClass", "show-overflow-tooltip": true, label: "物料种类", prop: "basicClass", width: "120" })) : l("", true), e(r).visible("sourceSpec") ? (t(), a(o, { key: "sourceSpec", "show-overflow-tooltip": true, align: "left", label: "原钢板规格", "min-width": "160", prop: "sourceSpec" })) : l("", true), e(r).visible("spec") ? (t(), a(o, { key: "spec", "show-overflow-tooltip": true, align: "left", label: "余料规格", "min-width": "160", prop: "spec" })) : l("", true), e(r).visible("cutEndTime") ? (t(), a(o, { key: "cutEndTime", "show-overflow-tooltip": true, align: "center", label: "生成时间", prop: "cutEndTime", width: "140" })) : l("", true), i(A, { showArea: "", showMonomer: "", showProject: "" })]), _: 1 }, 8, ["data", "data-format", "max-height", "onSortChange"])), [[k, e(c).loading]]), i(e(I))]);
  };
} };
export {
  z as default
};
