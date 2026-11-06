import { computed as p } from "vue";
import { resolveComponent as _ } from "vue";
import { openBlock as f } from "vue";
import { createElementBlock as y } from "vue";
import { createElementVNode as N } from "vue";
import { createVNode as s } from "vue";
import { unref as e } from "vue";
import { ElDatePicker as g } from "element-plus";
import { ElInput as h } from "element-plus";
import { _ as V, fg as Y, B as v, sY as b, C as x } from "../../../../shared/runtime.js";
const C = { __name: "header", setup(S) {
  const { projectTree: u } = Y(), d = { year: String((/* @__PURE__ */ new Date()).getFullYear()), projectNoOrName: void 0, schedulingStatus: void 0 };
  p(() => {
    const n = u.value.map((o) => (o.serialNumberName = o.serialNumber + " " + o.shortName, o)), a = n.filter((o) => o.status === t.status);
    return t.status ? a : n;
  });
  const { crud: l, query: t } = v(d);
  function m(n) {
    return n > /* @__PURE__ */ new Date();
  }
  return (n, a) => {
    const o = g, i = _("common-radio-button"), c = h;
    return f(), y("div", null, [N("div", null, [s(o, { modelValue: e(t).year, "onUpdate:modelValue": a[0] || (a[0] = (r) => e(t).year = r), type: "year", size: "default", class: "date-item filter-item", style: { width: "120px !important" }, placeholder: "选择年", format: "YYYY", "value-format": "YYYY", "disabled-date": m, onChange: e(l).toQuery }, null, 8, ["modelValue", "onChange"]), s(i, { modelValue: e(t).schedulingStatus, "onUpdate:modelValue": a[1] || (a[1] = (r) => e(t).schedulingStatus = r), options: e(b).ENUM, showOptionAll: "", class: "filter-item", type: "enum", onChange: e(l).toQuery }, null, 8, ["modelValue", "options", "onChange"])]), s(c, { modelValue: e(t).projectNoOrName, "onUpdate:modelValue": a[2] || (a[2] = (r) => e(t).projectNoOrName = r), modelModifiers: { trim: true }, placeholder: "项目搜索", style: { width: "270px" }, class: "filter-item" }, null, 8, ["modelValue"]), s(e(x))]);
  };
} }, E = V(C, [["__scopeId", "data-v-03aed487"]]);
export {
  E as default
};
