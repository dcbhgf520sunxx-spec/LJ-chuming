import { ref as _ } from "vue";
import { onMounted as j } from "vue";
import { resolveComponent as g } from "vue";
import { openBlock as h } from "vue";
import { createElementBlock as D } from "vue";
import { createVNode as l } from "vue";
import { unref as n } from "vue";
import { withKeys as y } from "vue";
import { withCtx as r } from "vue";
import { createBlock as S } from "vue";
import { createTextVNode as U } from "vue";
import { createCommentVNode as k } from "vue";
import { renderSlot as B } from "vue";
import { ElDatePicker as R } from "element-plus";
import { ElInput as T } from "element-plus";
import { ElCol as q } from "element-plus";
import { ElRow as I } from "element-plus";
import { P as K } from "../../../../../modules/index-5b9e6004.js";
import { b as O } from "../../../../../modules/win-bid-list-285b5b2e.js";
import { B as z, I as M, lR as Q, lq as W, C as H, G as L, E as $ } from "../../../../../shared/runtime.js";
import A from "./project-drawer.vue.js";
import "../../../../../modules/vue3-count-to.esm-8987f38d.js";
import "../../../../../modules/project-config-3fa4f850.js";
import "../../../../../modules/use-users-4d979987.js";
import "../../../../../modules/dept-cascader-6af417b9.js";
import "../../../../../modules/use-dept-b8e95315.js";
const G = { class: "head-container" }, ae = { __name: "header", props: { permission: { type: Object, default: () => {
} } }, setup(v, { expose: E }) {
  const w = { projectName: void 0, serialNumber: void 0, crmEnterpriseWarehousingName: void 0, date: [], startDate: void 0, endDate: void 0, crmProjectScheduleTypeEnum: void 0, tenderRequirements: [] }, { query: t, crud: d } = z(w), m = _(false), u = _({});
  j(() => {
    i();
  });
  function N() {
    m.value = true;
  }
  function b() {
    t.date && t.date.length > 1 ? (t.startDate = t.date[0], t.endDate = t.date[1]) : (t.startDate = void 0, t.endDate = void 0), i(), d.toQuery();
  }
  async function i() {
    try {
      const s = await O({ ...d.query });
      u.value = s || {};
    } catch (s) {
      console.log(s, "获取中标项目汇总失败");
    }
  }
  function a() {
    i(), d.toQuery();
  }
  return E({ handleChange: a }), (s, o) => {
    const C = R, V = g("common-select"), p = T, c = K, f = q, x = I, P = g("common-button");
    return h(), D("div", G, [l(C, { class: "filter-item", "value-format": "x", type: "daterange", shortcuts: n(M), "start-placeholder": "开始日期", "end-placeholder": "结束日期", modelValue: n(t).date, "onUpdate:modelValue": o[0] || (o[0] = (e) => n(t).date = e), onChange: b }, null, 8, ["shortcuts", "modelValue"]), l(V, { modelValue: n(t).crmProjectScheduleTypeEnum, "onUpdate:modelValue": o[1] || (o[1] = (e) => n(t).crmProjectScheduleTypeEnum = e), options: n(Q).ENUM, class: "filter-item", "show-option-all": "", clearable: "", size: "default", type: "enum", onChange: a }, null, 8, ["modelValue", "options"]), l(V, { modelValue: n(t).tenderRequirements, "onUpdate:modelValue": o[2] || (o[2] = (e) => n(t).tenderRequirements = e), options: n(W).ENUM, class: "filter-item", placeholder: "投标类型", "collapse-tags": true, "collapse-tags-tooltip": "", clearable: "", multiple: "", size: "default", type: "enum", onChange: a }, null, 8, ["modelValue", "options"]), l(p, { modelValue: n(t).projectName, "onUpdate:modelValue": o[3] || (o[3] = (e) => n(t).projectName = e), class: "filter-item", style: { width: "220px" }, placeholder: "项目名称搜索", onKeyup: y(a, ["enter"]) }, null, 8, ["modelValue"]), l(p, { modelValue: n(t).serialNumber, "onUpdate:modelValue": o[4] || (o[4] = (e) => n(t).serialNumber = e), class: "filter-item", style: { width: "220px" }, placeholder: "项目编号搜索", onKeyup: y(a, ["enter"]) }, null, 8, ["modelValue"]), l(p, { modelValue: n(t).crmEnterpriseWarehousingName, "onUpdate:modelValue": o[5] || (o[5] = (e) => n(t).crmEnterpriseWarehousingName = e), class: "filter-item", style: { width: "220px" }, placeholder: "建设单位搜索", onKeyup: y(a, ["enter"]) }, null, 8, ["modelValue"]), l(n(H)), l(x, { gutter: 24 }, { default: r(() => [l(f, { span: 8 }, { default: r(() => {
      var e;
      return [l(c, { name: "进行中", "text-color": "#626262", "num-color": "#1890ff", "end-val": ((e = u.value) == null ? void 0 : e.winningBidProcessing) || 0 }, null, 8, ["end-val"])];
    }), _: 1 }), l(f, { span: 8 }, { default: r(() => {
      var e;
      return [l(c, { name: "已中标", "text-color": "#626262", "num-color": "#1890ff", "end-val": ((e = u.value) == null ? void 0 : e.winningBidder) || 0 }, null, 8, ["end-val"])];
    }), _: 1 }), l(f, { span: 8 }, { default: r(() => {
      var e;
      return [l(c, { name: "未中标", "text-color": "#626262", "num-color": "#1890ff", "end-val": ((e = u.value) == null ? void 0 : e.unwinningBid) || 0 }, null, 8, ["end-val"])];
    }), _: 1 })]), _: 1 }), l(n($), null, { optLeft: r(() => [n(L)(v.permission.add) ? (h(), S(P, { key: 0, icon: "el-icon-plus", type: "success", size: "default", onClick: N }, { default: r(() => o[7] || (o[7] = [U(" 投标结果登记 ")])), _: 1, __: [7] })) : k("", true)]), viewLeft: r(() => [B(s.$slots, "printBtn")]), _: 3 }), l(A, { modelValue: m.value, "onUpdate:modelValue": o[6] || (o[6] = (e) => m.value = e), "is-view": false, onSuccess: a }, null, 8, ["modelValue"])]);
  };
} };
export {
  ae as default
};
