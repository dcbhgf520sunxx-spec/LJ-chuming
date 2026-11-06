import { ref as x } from "vue";
import { watch as Q } from "vue";
import { resolveComponent as h } from "vue";
import { resolveDirective as E } from "vue";
import { openBlock as m } from "vue";
import { createElementBlock as K } from "vue";
import { createElementVNode as _ } from "vue";
import { withDirectives as w } from "vue";
import { createBlock as v } from "vue";
import { withCtx as s } from "vue";
import { createVNode as t } from "vue";
import { unref as e } from "vue";
import { createTextVNode as C } from "vue";
import { withModifiers as L } from "vue";
import { createCommentVNode as B } from "vue";
import { withKeys as g } from "vue";
import { Fragment as S } from "vue";
import { ElCol as q } from "element-plus";
import { ElRow as D } from "element-plus";
import { ElInput as F } from "element-plus";
import { vLoading as M } from "element-plus";
import { a as P, b as T } from "../../../../../modules/roster-manage-12e649bc.js";
import { _ as z, B as $, G, L as H, o0 as R, n_ as O, C as J } from "../../../../../shared/runtime.js";
import { P as i } from "../../../../../modules/index-5b9e6004.js";
import { _ as W } from "../../../../../modules/subcontract-supplier-select-bab9e7f8.js";
import { u as X } from "../../../../../modules/use-global-project-id-change-to-query-ff2f0762.js";
import "../../../../../modules/vue3-count-to.esm-8987f38d.js";
const Y = { __name: "header", props: { nationList: { type: Array, default: () => [] }, permission: { type: Object, default: () => {
} } }, setup(c, { expose: I }) {
  const A = { status: void 0, sex: void 0, nation: void 0, name: void 0, idNumber: void 0, phone: void 0, supplierId: void 0 }, r = x({}), p = x(false), { crud: n, query: a } = $(A);
  X(n);
  async function b() {
    try {
      p.value = true;
      const d = await T({ projectId: n.query.projectId });
      r.value = d || {};
    } catch (d) {
      console.log(d);
    } finally {
      p.value = false;
    }
  }
  return Q(() => n.query.projectId, (d) => {
    d && b();
  }, { immediate: true }), I({ getAgeStatisticsData: b }), (d, o) => {
    var V;
    const u = q, U = D, j = h("common-button"), f = h("common-select"), y = F, k = M, N = E("permission");
    return m(), K(S, null, [_("div", null, [w((m(), v(U, { gutter: 20, class: "panel-group custom-row" }, { default: s(() => [t(u, { class: "card-panel-col custom-col" }, { default: s(() => {
      var l;
      return [t(e(i), { name: "在册人数", "text-color": "#626262", "num-color": "#fcca31", "end-val": ((l = r.value) == null ? void 0 : l.all) || 0, precision: 0 }, null, 8, ["end-val"])];
    }), _: 1 }), t(u, { class: "card-panel-col custom-col" }, { default: s(() => {
      var l;
      return [t(e(i), { name: "60岁以上", "text-color": "#626262", "num-color": "#337ecc", "end-val": ((l = r.value) == null ? void 0 : l.sixtyAgeAbove) || 0, precision: 0 }, null, 8, ["end-val"])];
    }), _: 1 }), t(u, { class: "card-panel-col custom-col" }, { default: s(() => {
      var l;
      return [t(e(i), { name: "45~60岁", "text-color": "#626262", "num-color": "#337ecc", "end-val": ((l = r.value) == null ? void 0 : l.fortyFiveAgeToSixtyAge) || 0, precision: 0 }, null, 8, ["end-val"])];
    }), _: 1 }), t(u, { class: "card-panel-col custom-col" }, { default: s(() => {
      var l;
      return [t(e(i), { name: "30~45岁", "text-color": "#626262", "num-color": "#5b9f35", "end-val": ((l = r.value) == null ? void 0 : l.thirtyAgeToFortyFiveAge) || 0, precision: 0 }, null, 8, ["end-val"])];
    }), _: 1 }), t(u, { class: "card-panel-col custom-col" }, { default: s(() => {
      var l;
      return [t(e(i), { name: "30岁以下", "text-color": "#626262", "num-color": "#5b9f35", "end-val": ((l = r.value) == null ? void 0 : l.thirtyAgeUnder) || 0, precision: 0 }, null, 8, ["end-val"])];
    }), _: 1 })]), _: 1 })), [[k, p.value]])]), _("div", null, [e(G)(c.permission.addInfo) ? (m(), v(j, { key: 0, class: "filter-item", type: "success", style: { "margin-bottom": "10px" }, onClick: L(e(n).toAdd, ["stop"]) }, { default: s(() => o[7] || (o[7] = [C(" 人员信息录入 ")])), _: 1, __: [7] }, 8, ["onClick"])) : B("", true), w((m(), v(H, { disabled: ((V = e(n).list) == null ? void 0 : V.length) <= 0, fn: e(P), params: e(a), class: "filter-item" }, { default: s(() => o[8] || (o[8] = [C(" 人员名单下载 ")])), _: 1, __: [8] }, 8, ["disabled", "fn", "params"])), [[N, c.permission.get]])]), _("div", null, [t(f, { modelValue: e(a).status, "onUpdate:modelValue": o[0] || (o[0] = (l) => e(a).status = l), options: e(R).ENUM, type: "enum", clearable: "", placeholder: "全部状态", style: { width: "120px" }, class: "filter-item", onChange: e(n).toQuery }, null, 8, ["modelValue", "options", "onChange"]), t(f, { modelValue: e(a).sex, "onUpdate:modelValue": o[1] || (o[1] = (l) => e(a).sex = l), options: e(O).ENUM, type: "enum", clearable: "", placeholder: "全部性别", style: { width: "120px" }, class: "filter-item", onChange: e(n).toQuery }, null, 8, ["modelValue", "options", "onChange"]), t(f, { modelValue: e(a).nation, "onUpdate:modelValue": o[2] || (o[2] = (l) => e(a).nation = l), options: c.nationList, "data-structure": { key: "id", label: "name", value: "name" }, clearable: "", filterable: "", type: "other", class: "filter-item", placeholder: "民族搜索", onChange: e(n).toQuery }, null, 8, ["modelValue", "options", "onChange"]), t(y, { modelValue: e(a).name, "onUpdate:modelValue": o[3] || (o[3] = (l) => e(a).name = l), size: "default", placeholder: "姓名搜索", style: { width: "200px" }, class: "filter-item", clearable: "", onKeyup: g(e(n).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), t(y, { modelValue: e(a).idNumber, "onUpdate:modelValue": o[4] || (o[4] = (l) => e(a).idNumber = l), size: "default", placeholder: "身份证搜索", style: { width: "200px" }, class: "filter-item", clearable: "", onKeyup: g(e(n).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), t(y, { modelValue: e(a).phone, "onUpdate:modelValue": o[5] || (o[5] = (l) => e(a).phone = l), size: "default", placeholder: "手机号码搜索", style: { width: "200px" }, class: "filter-item", clearable: "", onKeyup: g(e(n).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), t(W, { modelValue: e(a).supplierId, "onUpdate:modelValue": o[6] || (o[6] = (l) => e(a).supplierId = l), projectId: e(a).projectId, clearable: "", class: "filter-item", placeholder: "所属单位搜索", onChange: e(n).toQuery }, null, 8, ["modelValue", "projectId", "onChange"]), t(e(J))])], 64);
  };
} }, se = z(Y, [["__scopeId", "data-v-27195607"]]);
export {
  se as default
};
