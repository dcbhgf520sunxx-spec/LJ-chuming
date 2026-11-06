import { resolveComponent as _ } from "vue";
import { openBlock as i } from "vue";
import { createBlock as s } from "vue";
import { withCtx as e } from "vue";
import { createElementVNode as o } from "vue";
import { createVNode as w } from "vue";
import { unref as a } from "vue";
import { createTextVNode as C } from "vue";
import { toDisplayString as n } from "vue";
import { createCommentVNode as d } from "vue";
import { isRef as v } from "vue";
import { ElTableColumn as k } from "element-plus";
import { _ as W, u as A, D as p } from "../../../../../shared/runtime.js";
const F = { class: "dialog-title" }, V = { style: { position: "absolute", right: "20px" } }, D = { __name: "detail", props: { currentInfo: { type: Array, default: () => [] }, modelValue: { type: Boolean, require: true }, enclosureCategory: { type: [String, Number], default: void 0 }, globalProject: { type: Object, default: () => {
} } }, emits: ["success", "update:modelValue"], setup(r, { emit: c }) {
  const f = r, h = c, { visible: m, handleClose: g } = A({ emit: h, props: f });
  return (M, u) => {
    const y = _("common-button"), l = k, b = _("common-table"), x = _("common-drawer");
    return i(), s(x, { "append-to-body": "", modelValue: a(m), "onUpdate:modelValue": u[0] || (u[0] = (t) => v(m) ? m.value = t : null), top: "10vh", width: "600px", "before-close": a(g), title: "区域详情", "wrapper-closable": false, size: "900px" }, { title: e(() => [o("div", F, [u[2] || (u[2] = o("span", { style: { "margin-right": "5px" } }, "区域详情", -1)), o("span", V, [w(y, { size: "default", onClick: a(g) }, { default: e(() => u[1] || (u[1] = [C("关闭")])), _: 1, __: [1] }, 8, ["onClick"])])])]), content: e(() => [w(b, { ref: "tableRef", data: r.currentInfo, style: { width: "100%" }, "return-source-data": "", showEmptySymbol: false }, { default: e(() => [w(l, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), w(l, { key: "name", prop: "name", "show-overflow-tooltip": true, label: "区域", width: "140px" }, { default: e((t) => [o("span", null, n(t.row.name), 1)]), _: 1 }), w(l, { key: "quantity", prop: "quantity", "show-overflow-tooltip": true, label: "合计数量", "min-width": "150px" }, { default: e((t) => [o("span", null, n(t.row.quantity), 1)]), _: 1 }), r.enclosureCategory ? d("", true) : (i(), s(l, { key: "totalNetWeight", prop: "totalNetWeight", "show-overflow-tooltip": true, label: "合计毛重(kg)", "min-width": "150px" }, { default: e((t) => [o("span", null, n(t.row.totalGrossWeight ? t.row.totalGrossWeight.toFixed(a(p).COM_WT__KG) : "-"), 1)]), _: 1 })), r.enclosureCategory ? d("", true) : (i(), s(l, { key: "totalGrossWeight", prop: "totalGrossWeight", "show-overflow-tooltip": true, label: "合计净重(kg)", "min-width": "150px" }, { default: e((t) => [o("span", null, n(t.row.totalNetWeight ? t.row.totalNetWeight.toFixed(a(p).COM_WT__KG) : "-"), 1)]), _: 1 })), r.enclosureCategory ? (i(), s(l, { key: "totalLength", prop: "totalLength", "show-overflow-tooltip": true, label: "合计量(m)", "min-width": "160px" }, { default: e((t) => [o("span", null, n(t.row.totalLength ? t.row.totalLength.toFixed(a(p).COM_L__M) : "-"), 1)]), _: 1 })) : d("", true), r.enclosureCategory ? d("", true) : (i(), s(l, { key: "totalDrawingWeight", prop: "totalDrawingWeight", "show-overflow-tooltip": true, label: "合计图纸重（kg)", width: "200px" }, { default: e((t) => [o("span", null, n(t.row.totalDrawingWeight ? t.row.totalDrawingWeight.toFixed(a(p).COM_WT__KG) : "-"), 1)]), _: 1 })), r.enclosureCategory ? d("", true) : (i(), s(l, { key: "totalArea", prop: "totalArea", "show-overflow-tooltip": true, label: "合计面积（m²）", width: "200px" }, { default: e((t) => [o("span", null, n(t.row.totalArea ? t.row.totalArea.toFixed(a(p).COM_AREA__M2) : "-"), 1)]), _: 1 })), r.enclosureCategory ? d("", true) : (i(), s(l, { key: "topFlangeArea", prop: "topFlangeArea", "show-overflow-tooltip": true, label: "合计上翼缘面积（㎡）", width: "200px" }, { default: e((t) => [o("span", null, n(t.row.topFlangeArea ? t.row.topFlangeArea.toFixed(a(p).COM_AREA__M2) : "-"), 1)]), _: 1 }))]), _: 1 }, 8, ["data"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, O = W(D, [["__scopeId", "data-v-2b8cd21d"]]);
export {
  O as default
};
