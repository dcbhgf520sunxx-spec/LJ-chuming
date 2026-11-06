import { ref as g } from "vue";
import { resolveComponent as b } from "vue";
import { resolveDirective as Q } from "vue";
import { openBlock as c } from "vue";
import { createElementBlock as B } from "vue";
import { createElementVNode as m } from "vue";
import { withDirectives as V } from "vue";
import { createBlock as _ } from "vue";
import { withCtx as s } from "vue";
import { createVNode as a } from "vue";
import { unref as e } from "vue";
import { createTextVNode as x } from "vue";
import { withModifiers as I } from "vue";
import { createCommentVNode as K } from "vue";
import { withKeys as v } from "vue";
import { Fragment as S } from "vue";
import { ElCol as L } from "element-plus";
import { ElRow as T } from "element-plus";
import { ElInput as D } from "element-plus";
import { vLoading as F } from "element-plus";
import { r as M, b as P } from "../../../../modules/roster-34ff8428.js";
import { _ as R, B as z, G as q, o0 as G, n_ as H, iW as O, bE as $, C as j, L as W } from "../../../../shared/runtime.js";
import { P as d } from "../../../../modules/index-5b9e6004.js";
import { a as h } from "../../../../modules/user-2de6904c.js";
import "../../../../modules/vue3-count-to.esm-8987f38d.js";
const J = { class: "flex-rbc" }, X = { __name: "header", props: { nationList: { type: Array, default: () => [] } }, setup(C) {
  const w = { status: void 0, sex: void 0, nation: void 0, name: void 0, idNumber: void 0, phone: void 0, supplierId: void 0 }, r = g({}), p = g(false), { crud: n, query: t } = z(w);
  async function A() {
    try {
      p.value = true;
      const i = await P();
      r.value = i || {};
    } catch (i) {
      console.log(i);
    } finally {
      p.value = false;
    }
  }
  return A(), (i, o) => {
    const u = L, N = T, U = b("common-button"), f = b("common-select"), y = D, E = F, k = Q("permission");
    return c(), B(S, null, [m("div", null, [V((c(), _(N, { gutter: 20, class: "panel-group custom-row" }, { default: s(() => [a(u, { class: "card-panel-col custom-col" }, { default: s(() => {
      var l;
      return [a(e(d), { name: "在册人数", "text-color": "#626262", "num-color": "#fcca31", "end-val": ((l = r.value) == null ? void 0 : l.all) || 0, precision: 0 }, null, 8, ["end-val"])];
    }), _: 1 }), a(u, { class: "card-panel-col custom-col" }, { default: s(() => {
      var l;
      return [a(e(d), { name: "60岁以上", "text-color": "#626262", "num-color": "#337ecc", "end-val": ((l = r.value) == null ? void 0 : l.sixtyAgeAbove) || 0, precision: 0 }, null, 8, ["end-val"])];
    }), _: 1 }), a(u, { class: "card-panel-col custom-col" }, { default: s(() => {
      var l;
      return [a(e(d), { name: "45~60岁", "text-color": "#626262", "num-color": "#337ecc", "end-val": ((l = r.value) == null ? void 0 : l.fortyFiveAgeToSixtyAge) || 0, precision: 0 }, null, 8, ["end-val"])];
    }), _: 1 }), a(u, { class: "card-panel-col custom-col" }, { default: s(() => {
      var l;
      return [a(e(d), { name: "30~45岁", "text-color": "#626262", "num-color": "#5b9f35", "end-val": ((l = r.value) == null ? void 0 : l.thirtyAgeToFortyFiveAge) || 0, precision: 0 }, null, 8, ["end-val"])];
    }), _: 1 }), a(u, { class: "card-panel-col custom-col" }, { default: s(() => {
      var l;
      return [a(e(d), { name: "30岁以下", "text-color": "#626262", "num-color": "#5b9f35", "end-val": ((l = r.value) == null ? void 0 : l.thirtyAgeUnder) || 0, precision: 0 }, null, 8, ["end-val"])];
    }), _: 1 })]), _: 1 })), [[E, p.value]])]), m("div", null, [e(q)(e(h).add) ? (c(), _(U, { key: 0, type: "success", style: { "margin-bottom": "10px" }, onClick: I(e(n).toAdd, ["stop"]) }, { default: s(() => o[7] || (o[7] = [x(" 人员信息录入 ")])), _: 1, __: [7] }, 8, ["onClick"])) : K("", true)]), m("div", J, [m("div", null, [a(f, { modelValue: e(t).status, "onUpdate:modelValue": o[0] || (o[0] = (l) => e(t).status = l), options: e(G).ENUM, type: "enum", clearable: "", placeholder: "全部状态", style: { width: "120px" }, class: "filter-item", onChange: e(n).toQuery }, null, 8, ["modelValue", "options", "onChange"]), a(f, { modelValue: e(t).sex, "onUpdate:modelValue": o[1] || (o[1] = (l) => e(t).sex = l), options: e(H).ENUM, type: "enum", clearable: "", placeholder: "全部性别", style: { width: "120px" }, class: "filter-item", onChange: e(n).toQuery }, null, 8, ["modelValue", "options", "onChange"]), a(f, { modelValue: e(t).nation, "onUpdate:modelValue": o[2] || (o[2] = (l) => e(t).nation = l), options: C.nationList, "data-structure": { key: "id", label: "name", value: "name" }, clearable: "", filterable: "", type: "other", class: "filter-item", placeholder: "民族搜索", onChange: e(n).toQuery }, null, 8, ["modelValue", "options", "onChange"]), a(y, { modelValue: e(t).name, "onUpdate:modelValue": o[3] || (o[3] = (l) => e(t).name = l), size: "default", placeholder: "姓名搜索", style: { width: "200px" }, class: "filter-item", clearable: "", onKeyup: v(e(n).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), a(y, { modelValue: e(t).idNumber, "onUpdate:modelValue": o[4] || (o[4] = (l) => e(t).idNumber = l), size: "default", placeholder: "身份证搜索", style: { width: "200px" }, class: "filter-item", clearable: "", onKeyup: v(e(n).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), a(y, { modelValue: e(t).phone, "onUpdate:modelValue": o[5] || (o[5] = (l) => e(t).phone = l), size: "default", placeholder: "手机号码搜索", style: { width: "200px" }, class: "filter-item", clearable: "", onKeyup: v(e(n).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), a($, { modelValue: e(t).supplierId, "onUpdate:modelValue": o[6] || (o[6] = (l) => e(t).supplierId = l), showType: false, basicClass: e(O).LABOR_SUBCONTRACTING.V, clearable: "", class: "filter-item", placeholder: "所属单位搜索", style: { width: "260px" }, onChange: e(n).toQuery }, null, 8, ["modelValue", "basicClass", "onChange"]), a(e(j))]), V((c(), _(W, { fn: e(M), class: "filter-item", "response-header-result": "" }, { default: s(() => o[8] || (o[8] = [x(" 花名册下载 ")])), _: 1, __: [8] }, 8, ["fn"])), [[k, e(h).download]])])], 64);
  };
} }, te = R(X, [["__scopeId", "data-v-1eeb6eaa"]]);
export {
  te as default
};
