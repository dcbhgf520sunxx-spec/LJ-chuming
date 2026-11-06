import { resolveComponent as p } from "vue";
import { openBlock as m } from "vue";
import { createElementBlock as u } from "vue";
import { createVNode as e } from "vue";
import { withCtx as s } from "vue";
import { Fragment as c } from "vue";
import { ElTableColumn as h } from "element-plus";
import { bs as l } from "../../../../../../../shared/runtime.js";
const _ = { __name: "enclosure", setup(g) {
  function a(t) {
    t.totalLength = l(t.originTotalLength / t.originQuantity * t.quantity, 2, { toNum: true }), t.totalArea = l(t.originTotalArea / t.originQuantity * t.quantity, 2, { toNum: true }), t.enclosureTotalWeight = l(t.weight * t.quantity, 2, { toNum: true });
  }
  return (t, d) => {
    const o = h, r = p("common-input-number");
    return m(), u(c, null, [e(o, { "show-overflow-tooltip": "", prop: "name", label: "名称", align: "center", "min-width": "100px" }), e(o, { "show-overflow-tooltip": "", prop: "serialNumber", label: "编号", align: "center", "min-width": "100px" }), e(o, { "show-overflow-tooltip": "", prop: "specification", label: "规格", align: "center", "min-width": "140px" }), e(o, { "show-overflow-tooltip": "", prop: "length", label: "单长(mm)", align: "center", "min-width": "100px" }), e(o, { "show-overflow-tooltip": "", prop: "quantity", label: "数量", align: "center", "min-width": "100px" }, { default: s(({ row: { sourceRow: n } }) => [e(r, { modelValue: n.quantity, "onUpdate:modelValue": (i) => n.quantity = i, "controls-position": "right", max: n.originQuantity, min: 1, size: "default", step: 1, placeholder: "数量", onChange: (i) => a(n) }, null, 8, ["modelValue", "onUpdate:modelValue", "max", "onChange"])]), _: 1 }), e(o, { "show-overflow-tooltip": "", prop: "totalLength", label: "总长(m)", align: "center", "min-width": "110" }), e(o, { "show-overflow-tooltip": "", prop: "totalArea", label: "总面积(㎡)", align: "center", "min-width": "110" }), e(o, { "show-overflow-tooltip": "", prop: "weight", label: "单重(kg)", align: "center", "min-width": "110" }), e(o, { "show-overflow-tooltip": "", prop: "enclosureTotalWeight", label: "总重(kg)", align: "center", "min-width": "110" })], 64);
  };
} };
export {
  _ as default
};
