import { ref as n } from "vue";
import { resolveComponent as c } from "vue";
import { openBlock as y } from "vue";
import { createBlock as h } from "vue";
import { withCtx as l } from "vue";
import { createVNode as o } from "vue";
import { unref as s } from "vue";
import { createTextVNode as x } from "vue";
import { toDisplayString as v } from "vue";
import { isRef as k } from "vue";
import { ElTableColumn as V } from "element-plus";
import { _ as N, u as B, o as R } from "../../../../../shared/runtime.js";
const C = { __name: "production-state", props: { modelValue: { type: Boolean, require: true }, list: { type: Array, default: () => [] } }, emits: ["success", "update:modelValue"], setup(r, { emit: d }) {
  const m = r, p = n(), u = n(), _ = d, { visible: e, handleClose: f } = B({ emit: _, props: m }), { maxHeight: b } = R({ mainBox: ".production-state-detail", extraBox: ".el-dialog__header", wrapperBox: ".el-dialog__body", navbar: false, clientHRepMainH: true }, e);
  return (H, i) => {
    const t = V, g = c("common-table"), w = c("common-dialog");
    return y(), h(w, { ref_key: "dialogRef", ref: u, "append-to-body": "", "close-on-click-modal": false, "before-close": s(f), modelValue: s(e), "onUpdate:modelValue": i[0] || (i[0] = (a) => k(e) ? e.value = a : null), title: "生产状态", "wrapper-closable": false, size: "60%", "custom-class": "production-state-detail" }, { default: l(() => [o(g, { ref_key: "tableRef", ref: p, border: "", data: r.list, "max-height": s(b), style: { width: "100%" }, class: "table-form", stripe: false, "return-source-data": "", showEmptySymbol: false }, { default: l(() => [o(t, { key: "serialNumber", prop: "serialNumber", label: "编号", "min-width": "100", "show-overflow-tooltip": "" }), o(t, { key: "specification", prop: "specification", label: "产线", "min-width": "160", "show-overflow-tooltip": "" }), o(t, { key: "drawingNumber", prop: "drawingNumber", label: "工序", align: "left", "show-overflow-tooltip": "" }, { default: l((a) => [x(v(a.row.drawingNumber || "-"), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])]), _: 1 }, 8, ["before-close", "modelValue"]);
  };
} }, I = N(C, [["__scopeId", "data-v-7afa58b0"]]);
export {
  I as default
};
