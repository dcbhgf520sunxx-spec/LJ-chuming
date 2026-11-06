import { openBlock as N } from "vue";
import { createElementBlock as _ } from "vue";
import { createElementVNode as m } from "vue";
import { createVNode as a } from "vue";
import { unref as e } from "vue";
import { withKeys as s } from "vue";
import { withCtx as l } from "vue";
import { renderSlot as b } from "vue";
import { ElDatePicker as V } from "element-plus";
import { ElInput as h } from "element-plus";
import { ElCol as R } from "element-plus";
import { ElRow as U } from "element-plus";
import { B as v, I as x, C as Q } from "../../../../../shared/runtime.js";
import { P as p } from "../../../../../modules/index-5b9e6004.js";
import { _ as T } from "../../../../../modules/basics-config-select-53b77c54.js";
import "../../../../../modules/vue3-count-to.esm-8987f38d.js";
import "../../../../../modules/use-crm-basics-c35b230b.js";
const D = { class: "head-container" }, k = { __name: "header", props: { summary: { type: Object, default: () => {
} } }, setup(f) {
  const d = f, y = { date: [], startDate: void 0, endDate: void 0, unitClassConfigurationId: void 0, unitPropertyAllocationConfigId: void 0, industryConfigurationId: void 0, unitReputationAllocationConfigId: void 0, businessName: void 0, creditCode: void 0, informantUserName: void 0 }, { crud: r, query: n } = v(y);
  function C() {
    n.date && n.date.length > 1 ? (n.startDate = n.date[0], n.endDate = n.date[1]) : (n.startDate = void 0, n.endDate = void 0), r.toQuery();
  }
  return (c, t) => {
    const I = V, i = h, u = R, g = U;
    return N(), _("div", D, [m("div", null, [a(I, { modelValue: e(n).date, "onUpdate:modelValue": t[0] || (t[0] = (o) => e(n).date = o), class: "filter-item", shortcuts: e(x), type: "daterange", "value-format": "x", "start-placeholder": "开始日期", "end-placeholder": "结束日期", onChange: C }, null, 8, ["modelValue", "shortcuts"]), a(T, { firmNatureId: e(n).unitClassConfigurationId, "onUpdate:firmNatureId": t[1] || (t[1] = (o) => e(n).unitClassConfigurationId = o), firmTypeId: e(n).unitPropertyAllocationConfigId, "onUpdate:firmTypeId": t[2] || (t[2] = (o) => e(n).unitPropertyAllocationConfigId = o), industryId: e(n).industryConfigurationId, "onUpdate:industryId": t[3] || (t[3] = (o) => e(n).industryConfigurationId = o), corporateRepurationId: e(n).unitReputationAllocationConfigId, "onUpdate:corporateRepurationId": t[4] || (t[4] = (o) => e(n).unitReputationAllocationConfigId = o), onFirmNatureChange: e(r).toQuery, onFirmTypeChange: e(r).toQuery, onIndustryChange: e(r).toQuery, onCorporateRepurationChange: e(r).toQuery, firmNatureClearable: "", corporateRepurationClearable: "", firmTypeClearable: "", industryClearable: "", class: "filter-item" }, null, 8, ["firmNatureId", "firmTypeId", "industryId", "corporateRepurationId", "onFirmNatureChange", "onFirmTypeChange", "onIndustryChange", "onCorporateRepurationChange"])]), m("div", null, [a(i, { modelValue: e(n).businessName, "onUpdate:modelValue": t[5] || (t[5] = (o) => e(n).businessName = o), class: "filter-item", style: { width: "210px" }, placeholder: "企业名称搜索", clearable: "", onKeyup: s(e(r).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), a(i, { modelValue: e(n).creditCode, "onUpdate:modelValue": t[6] || (t[6] = (o) => e(n).creditCode = o), class: "filter-item", style: { width: "210px" }, placeholder: "社会统一信用代码", clearable: "", onKeyup: s(e(r).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), a(i, { modelValue: e(n).informantUserName, "onUpdate:modelValue": t[7] || (t[7] = (o) => e(n).informantUserName = o), class: "filter-item", style: { width: "210px" }, placeholder: "登记人", clearable: "", onKeyup: s(e(r).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), a(e(Q))]), a(g, { gutter: 20 }, { default: l(() => [a(u, { span: 8 }, { default: l(() => [a(e(p), { name: "企业数量", "text-color": "#626262", "num-color": "#1890ff", "end-val": d.summary.enterprisesCount || 0 }, null, 8, ["end-val"])]), _: 1 }), a(u, { span: 8 }, { default: l(() => [a(e(p), { name: "国内", "text-color": "#626262", "num-color": "#1890ff", "end-val": d.summary.domesticEnterprisesCount || 0 }, null, 8, ["end-val"])]), _: 1 }), a(u, { span: 8 }, { default: l(() => [a(e(p), { name: "国外", "text-color": "#626262", "num-color": "#1890ff", "end-val": d.summary.foreignEnterprisesCount || 0 }, null, 8, ["end-val"])]), _: 1 })]), _: 1 }), b(c.$slots, "printBtn")]);
  };
} };
export {
  k as default
};
