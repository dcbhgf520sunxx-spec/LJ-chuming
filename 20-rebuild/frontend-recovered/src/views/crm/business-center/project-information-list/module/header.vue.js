import { onMounted as f } from "vue";
import { ref as V } from "vue";
import { openBlock as h } from "vue";
import { createElementBlock as y } from "vue";
import { createVNode as o } from "vue";
import { unref as t } from "vue";
import { withKeys as i } from "vue";
import { renderSlot as g } from "vue";
import { ElDatePicker as b } from "element-plus";
import { ElInput as C } from "element-plus";
import { B as _, I as E, C as N } from "../../../../../shared/runtime.js";
import { g as S } from "../../../../../modules/project-information-ad6c6e75.js";
import U from "./panels.vue.js";
import { _ as w } from "../../../../../modules/dept-cascader-6af417b9.js";
import "../../../../../modules/vue3-count-to.esm-8987f38d.js";
import "../../../../../modules/use-dept-b8e95315.js";
const B = { class: "head-container" }, k = { __name: "header", setup(I) {
  f(() => {
    u();
  });
  const r = V([]);
  async function u() {
    const l = await S();
    console.log(l);
    for (let a = 0; a < 5; a++) a === 0 ? r.value.push({ label: "项目备案", startVal: 0, endVal: l.numberOfIcpFilingsCount, addStartVal: 0, addEndVal: l.numberOfIcpFilingsCountByThisMonth, icon: "crm-record" }) : a === 1 ? r.value.push({ label: "项目跟进", startVal: 0, endVal: l.projectFollowUpCount, addStartVal: 0, addEndVal: l.projectFollowUpCountByThisMonth, icon: "crm-follow-up" }) : a === 2 ? r.value.push({ label: "资格预审", startVal: 0, endVal: l.preQualificationCount, addStartVal: 0, addEndVal: l.preQualificationCountByThisMonth, icon: "crm-beforehand-check" }) : a === 3 ? r.value.push({ label: "项目投标", startVal: 0, endVal: l.biddingRegistrationCount, addStartVal: 0, addEndVal: l.biddingRegistrationCountByThisMonth, icon: "crm-call-for-bid" }) : r.value.push({ label: "中标项目", startVal: 0, endVal: l.winningBidCount, addStartVal: 0, addEndVal: l.WinningRate, icon: "crm-tender" });
  }
  const m = { date: [], startDate: void 0, endDate: void 0, crmEnterpriseWarehousingName: void 0, projectName: void 0, informantUserName: void 0, departmentIds: [] }, { query: e, crud: d } = _(m);
  function p() {
    e.date && e.date.length > 1 ? (e.startDate = e.date[0], e.endDate = e.date[1]) : (e.startDate = void 0, e.endDate = void 0), d.toQuery();
  }
  return (l, a) => {
    const c = b, s = C;
    return h(), y("div", B, [o(c, { modelValue: t(e).date, "onUpdate:modelValue": a[0] || (a[0] = (n) => t(e).date = n), class: "filter-item", "start-placeholder": "开始日期", "end-placeholder": "结束日期", shortcuts: t(E), type: "daterange", clearable: "", "value-format": "x", onChange: p }, null, 8, ["modelValue", "shortcuts"]), o(w, { modelValue: t(e).departmentIds, "onUpdate:modelValue": a[1] || (a[1] = (n) => t(e).departmentIds = n), filterable: "", class: "filter-item", "collapse-tags": true, multiple: "", clearable: "", "collapse-tags-tooltip": "", style: { width: "240px" }, placeholder: "选择部门", onChange: t(d).toQuery }, null, 8, ["modelValue", "onChange"]), o(s, { modelValue: t(e).crmEnterpriseWarehousingName, "onUpdate:modelValue": a[2] || (a[2] = (n) => t(e).crmEnterpriseWarehousingName = n), class: "filter-item", clearable: "", style: { width: "210px" }, placeholder: "企业名称搜索", onKeyup: i(t(d).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), o(s, { modelValue: t(e).projectName, "onUpdate:modelValue": a[3] || (a[3] = (n) => t(e).projectName = n), class: "filter-item", clearable: "", style: { width: "210px" }, placeholder: "项目名称搜索", onKeyup: i(t(d).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), o(s, { modelValue: t(e).informantUserName, "onUpdate:modelValue": a[4] || (a[4] = (n) => t(e).informantUserName = n), class: "filter-item", clearable: "", style: { width: "210px" }, placeholder: "登记人搜索", onKeyup: i(t(d).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), o(t(N)), o(U, { "data-list": r.value }, null, 8, ["data-list"]), g(l.$slots, "printBtn")]);
  };
} };
export {
  k as default
};
