import { ref as p } from "vue";
import { computed as q } from "vue";
import { watch as F } from "vue";
import { resolveComponent as y } from "vue";
import { openBlock as i } from "vue";
import { createBlock as f } from "vue";
import { withCtx as a } from "vue";
import { createVNode as r } from "vue";
import { unref as t } from "vue";
import { createTextVNode as _ } from "vue";
import { createElementBlock as B } from "vue";
import { Fragment as N } from "vue";
import { renderList as j } from "vue";
import { createCommentVNode as O } from "vue";
import { ElFormItem as P } from "element-plus";
import { ElOption as T } from "element-plus";
import { ElSelect as A } from "element-plus";
import { ElRadio as D } from "element-plus";
import { ElRadioGroup as G } from "element-plus";
import { ElForm as Q } from "element-plus";
import { l as m, ao as $ } from "../../../../../../../shared/runtime.js";
import { _ as H } from "../../../../../../../modules/factory-select-b8d0a4ac.js";
import { u as h } from "../../../../../../../modules/index-7da9f094.js";
function J(n) {
  return m({ url: "/api/mes/enclosure/team/page", method: "get", params: n });
}
function K(n) {
  return m({ url: "/api/mes/enclosure/team", method: "post", data: n });
}
function W(n) {
  return m({ url: "/api/mes/enclosure/team", method: "put", data: n });
}
function X(n) {
  return m({ url: "/api/mes/enclosure/team", method: "delete", data: { ids: n } });
}
function Y(n) {
  return m({ url: "/api/mes/enclosure/productionLine/page", method: "get", params: n });
}
const re = { get: J, add: K, edit: W, del: X }, Z = { __name: "form", setup(n) {
  const g = p(), I = p(), V = { id: void 0, factoryId: void 0, leaderId: void 0, hasMen: true }, { crud: s, form: e } = $(V, g), v = q(() => s.status.edit >= 1), C = { factoryId: [{ required: true, message: "请选择工厂", trigger: "change" }], productionLineId: [{ required: true, message: "请选择产线", trigger: "change" }], leaderId: [{ required: true, message: "请选择组长", trigger: "change" }], hasMen: [{ required: true, message: "请选择是否组员", trigger: "change" }], memberIds: [{ required: true, message: "请选择组员", trigger: "change" }] };
  function w(d) {
    e.leader = d;
  }
  const c = p([]);
  F(() => e.factoryId, async (d) => {
    d ? await x() : c.value = [];
  }, { immediate: true });
  async function x() {
    try {
      const { content: d } = await Y({ boolEnabledEnum: true, factoryId: e.factoryId });
      c.value = d || [];
    } catch (d) {
      console.log(d);
    }
  }
  function L(d) {
    e.members = d;
  }
  function k() {
    e.memberIds = [], e.members = [], e.memberNames = "";
  }
  return (d, o) => {
    const E = y("common-button"), u = P, R = T, M = A, b = D, S = G, U = Q, z = y("common-dialog");
    return i(), f(z, { "before-close": t(s).cancelCU, "close-on-click-modal": false, title: t(s).status.title, visible: t(s).status.cu > 0, "append-to-body": "", width: "500px" }, { titleRight: a(() => [r(E, { loading: t(s).status.cu === 2, size: "default", type: "primary", onClick: t(s).submitCU }, { default: a(() => o[5] || (o[5] = [_("确认 ")])), _: 1, __: [5] }, 8, ["loading", "onClick"])]), default: a(() => [r(U, { ref_key: "formRef", ref: g, model: t(e), rules: C, "label-width": "100px", size: "default" }, { default: a(() => [r(u, { label: "工厂", prop: "factoryId" }, { default: a(() => [r(H, { modelValue: t(e).factoryId, "onUpdate:modelValue": o[0] || (o[0] = (l) => t(e).factoryId = l), disabled: v.value, placeholder: "请选择工厂", style: { width: "270px" } }, null, 8, ["modelValue", "disabled"])]), _: 1 }), r(u, { label: "产线", prop: "productionLineId" }, { default: a(() => [r(M, { modelValue: t(e).productionLineId, "onUpdate:modelValue": o[1] || (o[1] = (l) => t(e).productionLineId = l), class: "filter-item", placeholder: "请选择产线", style: { width: "270px" }, type: "other" }, { default: a(() => [(i(true), B(N, null, j(c.value, (l) => (i(), f(R, { key: l.id, label: l.name, value: l.id }, null, 8, ["label", "value"]))), 128))]), _: 1 }, 8, ["modelValue"])]), _: 1 }), r(u, { label: "组长", prop: "leaderId" }, { default: a(() => [r(t(h), { ref_key: "leaderSelectRef", ref: I, modelValue: t(e).leaderId, "onUpdate:modelValue": o[2] || (o[2] = (l) => t(e).leaderId = l), size: "default", clearable: "", placeholder: "请选择班组组长", style: { width: "270px" }, onChange: w }, null, 8, ["modelValue"])]), _: 1 }), r(u, { label: "是否需要组员", "label-width": "120px", prop: "hasMen" }, { default: a(() => [r(S, { modelValue: t(e).hasMen, "onUpdate:modelValue": o[3] || (o[3] = (l) => t(e).hasMen = l), onChange: k }, { default: a(() => [r(b, { value: true }, { default: a(() => o[6] || (o[6] = [_("是")])), _: 1, __: [6] }), r(b, { value: false }, { default: a(() => o[7] || (o[7] = [_("否")])), _: 1, __: [7] })]), _: 1 }, 8, ["modelValue"])]), _: 1 }), t(e).hasMen ? (i(), f(u, { key: 0, label: "组员", prop: "memberIds" }, { default: a(() => [r(t(h), { ref: "memberSelectRef", modelValue: t(e).memberIds, "onUpdate:modelValue": o[4] || (o[4] = (l) => t(e).memberIds = l), "disabled-value": [t(e).leaderId], multiple: true, size: "default", placeholder: "请选择班组成员", style: { width: "270px" }, onChange: L }, null, 8, ["modelValue", "disabled-value"])]), _: 1 })) : O("", true)]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "title", "visible"]);
  };
} }, ne = Object.freeze(Object.defineProperty({ __proto__: null, default: Z }, Symbol.toStringTag, { value: "Module" }));
export {
  Z as _,
  re as c,
  ne as f
};
