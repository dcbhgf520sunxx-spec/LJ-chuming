import { useStore as V } from "vuex";
import { computed as f } from "vue";
import { watch as b } from "vue";
import { resolveComponent as g } from "vue";
import { openBlock as N } from "vue";
import { createElementBlock as T } from "vue";
import { withDirectives as w } from "vue";
import { vShow as C } from "vue";
import { unref as e } from "vue";
import { createElementVNode as _ } from "vue";
import { createVNode as n } from "vue";
import { withKeys as m } from "vue";
import y from "moment";
import { ElDatePicker as v } from "element-plus";
import { ElInput as D } from "element-plus";
import { B as Q, ub as P, C as q, E as K } from "../../../../../shared/runtime.js";
const U = (u) => {
  const d = V(), r = f(() => d.state.config.loaded.qualityProblemType);
  if (r.value || d.dispatch("config/fetchQualityProblemType"), u) {
    const i = b(r, (l) => {
      l && setTimeout(() => {
        u(), i();
      }, 0);
    }, { immediate: true });
  }
  return { qualityProblemType: f(() => d.state.config.qualityProblemType), loaded: r };
}, x = { class: "head-container" }, O = { __name: "header", setup(u) {
  const { loaded: d, qualityProblemType: r } = U(), i = { date: void 0, startDate: void 0, endDate: void 0, problemTypeId: void 0, boolChangeStatus: void 0, projectName: void 0, supplierName: void 0, promoterName: void 0 }, { crud: l, query: t } = Q(i);
  function c() {
    t.date && t.date.length > 1 ? (t.startDate = y(t.date[0]).valueOf(), t.endDate = y(t.date[1]).valueOf()) : (t.startDate = void 0, t.endDate = void 0), l.toQuery();
  }
  return (S, o) => {
    const h = v, p = g("common-radio-button"), s = D;
    return N(), T("div", x, [w(_("div", null, [n(h, { modelValue: e(t).date, "onUpdate:modelValue": o[0] || (o[0] = (a) => e(t).date = a), type: "daterange", "range-separator": ":", size: "default", class: "filter-item date-item", "start-placeholder": "开始时间", "end-placeholder": "结束时间", style: { width: "240px" }, onChange: c }, null, 8, ["modelValue"]), n(p, { modelValue: e(t).problemTypeId, "onUpdate:modelValue": o[1] || (o[1] = (a) => e(t).problemTypeId = a), options: e(r), showOptionAll: "", optionAllValue: void 0, type: "other", loading: !e(d), dataStructure: { key: "id", label: "name", value: "id" }, class: "filter-item", onChange: e(l).toQuery }, null, 8, ["modelValue", "options", "loading", "onChange"]), n(p, { modelValue: e(t).boolChangeStatus, "onUpdate:modelValue": o[2] || (o[2] = (a) => e(t).boolChangeStatus = a), options: e(P).ENUM, showOptionAll: "", optionAllValue: void 0, type: "enum", class: "filter-item", onChange: e(l).toQuery }, null, 8, ["modelValue", "options", "onChange"]), n(s, { modelValue: e(t).projectName, "onUpdate:modelValue": o[3] || (o[3] = (a) => e(t).projectName = a), modelModifiers: { trim: true }, placeholder: "项目", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: m(e(l).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), n(s, { modelValue: e(t).supplierName, "onUpdate:modelValue": o[4] || (o[4] = (a) => e(t).supplierName = a), modelModifiers: { trim: true }, placeholder: "分包单位", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: m(e(l).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), n(s, { modelValue: e(t).promoterName, "onUpdate:modelValue": o[5] || (o[5] = (a) => e(t).promoterName = a), modelModifiers: { trim: true }, placeholder: "发起人", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: m(e(l).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), n(e(q))], 512), [[C, e(l).searchToggle]]), n(e(K))]);
  };
} };
export {
  O as default
};
