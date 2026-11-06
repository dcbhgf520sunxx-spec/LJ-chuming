import { useRoute as q } from "vue-router";
import { ref as i } from "vue";
import { computed as N } from "vue";
import { openBlock as p } from "vue";
import { createElementBlock as x } from "vue";
import { createVNode as s } from "vue";
import { unref as r } from "vue";
import { createBlock as B } from "vue";
import { withCtx as d } from "vue";
import { createTextVNode as c } from "vue";
import { ElRadioGroup as T } from "element-plus";
import { createCommentVNode as V } from "vue";
import { Fragment as g } from "vue";
import { ElRadioButton as C } from "element-plus";
import { b as h } from "../../../modules/bim-model-view-dbf77a11.js";
import "../../../modules/bimfaceAPI-c2661893.js";
import "../../../modules/model-0ac957f7.js";
import "../../../shared/runtime.js";
import "../../../modules/index-d6a37d29.js";
import "../../../modules/drawing-preview-fullscreen-dialog-60155503.js";
import "../../../modules/use-chart-59e4b63c.js";
import "../../../modules/index-18acf776.js";
const F = { __name: "index", setup(k) {
  const e = q(), v = e.query.productId && Number(e.query.productId), y = e.query.productType && Number(e.query.productType), m = e.query.showAll && Number(e.query.showAll) || 0, _ = e.query.serialNumber, b = e.query.monomerId && Number(e.query.monomerId), f = e.query.areaId && Number(e.query.areaId), l = i(), n = i(false), w = N(() => {
    var a;
    return (a = l.value) == null ? void 0 : a.modelLoaded;
  });
  function I() {
    var a, o, u;
    if (n.value) (a = l.value) == null || a.clearIsolation();
    else {
      const t = (o = l.value) == null ? void 0 : o.previewSNElementIds.value;
      if (!t || !(t != null && t.length)) return;
      (u = l.value) == null || u.isolateComponentsById(t);
    }
  }
  return (a, o) => {
    const u = C;
    return p(), x(g, null, [s(r(h), { ref_key: "mobileModelPreview", ref: l, "monomer-id": r(b), areaId: r(f), "serial-number": r(_), productId: r(v), productType: r(y), "preview-show-all": !!r(m), visible: true, "is-preview": "", "is-mobile": "", class: "mobile-model-preview" }, null, 8, ["monomer-id", "areaId", "serial-number", "productId", "productType", "preview-show-all"]), !r(m) && w.value ? (p(), B(r(T), { key: 0, class: "mobile-model-preview-radio", modelValue: n.value, "onUpdate:modelValue": o[0] || (o[0] = (t) => n.value = t), onChange: I }, { default: d(() => [s(u, { value: false }, { default: d(() => o[1] || (o[1] = [c("显示构件")])), _: 1, __: [1] }), s(u, { value: true }, { default: d(() => o[2] || (o[2] = [c("显示全部")])), _: 1, __: [2] })]), _: 1 }, 8, ["modelValue"])) : V("", true)], 64);
  };
} };
export {
  F as default
};
