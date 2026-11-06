import m from "moment";
import { watch as f } from "vue";
import { resolveComponent as y } from "vue";
import { openBlock as h } from "vue";
import { createElementBlock as _ } from "vue";
import { withDirectives as v } from "vue";
import { vShow as b } from "vue";
import { unref as e } from "vue";
import { createElementVNode as V } from "vue";
import { createVNode as n } from "vue";
import { ElDatePicker as g } from "element-plus";
import { tQ as s, B as I } from "../../../../../shared/runtime.js";
const T = { class: "head-container" }, j = { __name: "header", props: { projectId: { type: [Number, String], default: void 0 } }, setup(u) {
  const p = { projectId: { value: void 0, resetAble: false }, year: m().valueOf(), productType: s.ARTIFACT.V }, { crud: t, query: o } = I(p), l = u;
  return f(() => l.projectId, (d) => {
    d && (t.query.projectId = l.projectId, t.toQuery());
  }, { immediate: true, deep: true }), (d, r) => {
    const c = g, i = y("common-radio-button");
    return h(), _("div", T, [v(V("div", null, [n(c, { modelValue: e(o).year, "onUpdate:modelValue": r[0] || (r[0] = (a) => e(o).year = a), type: "year", size: "default", class: "date-item filter-item", style: { width: "120px !important" }, format: "YYYY", clearable: false, "value-format": "x", placeholder: "选择年", "disabled-date": (a) => a > /* @__PURE__ */ new Date(), onChange: e(t).toQuery }, null, 8, ["modelValue", "disabled-date", "onChange"]), n(i, { modelValue: e(o).productType, "onUpdate:modelValue": r[1] || (r[1] = (a) => e(o).productType = a), options: e(s).ENUM, type: "enum", size: "default", clearable: "", default: "", class: "filter-item", placeholder: "请选择产品类别", onChange: e(t).toQuery }, null, 8, ["modelValue", "options", "onChange"])], 512), [[b, e(t).searchToggle]])]);
  };
} };
export {
  j as default
};
