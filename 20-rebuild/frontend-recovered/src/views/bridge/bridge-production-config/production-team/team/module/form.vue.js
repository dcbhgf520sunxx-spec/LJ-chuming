import { ref as m } from "vue";
import { computed as R } from "vue";
import { resolveComponent as c } from "vue";
import { openBlock as S } from "vue";
import { createBlock as w } from "vue";
import { withCtx as a } from "vue";
import { createVNode as t } from "vue";
import { unref as e } from "vue";
import { createTextVNode as z } from "vue";
import { ElFormItem as F } from "element-plus";
import { ElForm as U } from "element-plus";
import { aY as T, ao as q } from "../../../../../../shared/runtime.js";
import { _ as E } from "../../../../../../modules/factory-select-b8d0a4ac.js";
import { _ as B } from "../../../../../../modules/process-select-cf7cf476.js";
import { u as b } from "../../../../../../modules/index-7da9f094.js";
import "../../../../../../modules/raf-ac2cc4f2.js";
import "../../../../../../modules/use-bridge-process-6f90ba68.js";
import "../../../../../../modules/use-users-4d979987.js";
const G = { __name: "form", setup(N) {
  const i = m(), f = m(), g = m(), _ = m(), I = m(), y = { id: void 0, processId: void 0, leaderId: void 0, organizationType: T.IN_STAFF.V, memberIds: [] }, { crud: d, form: l } = q(y, i), p = R(() => d.status.edit >= 1), V = { factoryId: [{ required: true, message: "请选择工厂", trigger: "change" }], processId: [{ required: true, message: "请选择工序", trigger: "change" }], leaderId: [{ required: true, message: "请选择组长", trigger: "change" }], memberIds: [{ required: true, message: "请选择组员", trigger: "change" }] };
  function h(s) {
    var o, n;
    I.value = (n = (o = f.value) == null ? void 0 : o.getOption(s)) == null ? void 0 : n.productType;
  }
  function C(s) {
    l.leader = s;
  }
  function v(s) {
    l.members = s;
  }
  return (s, o) => {
    const n = c("common-button"), u = F, x = U, k = c("common-dialog");
    return S(), w(k, { "append-to-body": "", "close-on-click-modal": false, "before-close": e(d).cancelCU, visible: e(d).status.cu > 0, title: e(d).status.title, width: "500px" }, { titleRight: a(() => [t(n, { loading: e(d).status.cu === 2, type: "primary", size: "default", onClick: e(d).submitCU }, { default: a(() => o[4] || (o[4] = [z("确认")])), _: 1, __: [4] }, 8, ["loading", "onClick"])]), default: a(() => [t(x, { ref_key: "formRef", ref: i, model: e(l), rules: V, size: "default", "label-width": "100px" }, { default: a(() => [t(u, { label: "工厂", prop: "factoryId" }, { default: a(() => [t(E, { disabled: p.value, modelValue: e(l).factoryId, "onUpdate:modelValue": o[0] || (o[0] = (r) => e(l).factoryId = r), placeholder: "请选择工厂", style: { width: "270px" } }, null, 8, ["disabled", "modelValue"])]), _: 1 }), t(u, { label: "工序", prop: "processId" }, { default: a(() => [t(e(B), { ref_key: "processSelectRef", ref: f, modelValue: e(l).processId, "onUpdate:modelValue": o[1] || (o[1] = (r) => e(l).processId = r), containsMachinePart: "", disabled: p.value, size: "default", multiple: false, style: { width: "270px" }, onChange: h }, null, 8, ["modelValue", "disabled"])]), _: 1 }), t(u, { label: "组长", prop: "leaderId" }, { default: a(() => [t(e(b), { ref_key: "leaderSelectRef", ref: g, modelValue: e(l).leaderId, "onUpdate:modelValue": o[2] || (o[2] = (r) => e(l).leaderId = r), size: "default", "disabled-value": [...e(l).memberIds], placeholder: "请选择班组组长", style: { width: "270px" }, onChange: C }, null, 8, ["modelValue", "disabled-value"])]), _: 1 }), t(u, { label: "组员", prop: "memberIds" }, { default: a(() => [t(e(b), { ref_key: "memberSelectRef", ref: _, modelValue: e(l).memberIds, "onUpdate:modelValue": o[3] || (o[3] = (r) => e(l).memberIds = r), size: "default", "disabled-value": [e(l).leaderId], placeholder: "请选择班组成员", multiple: true, style: { width: "270px" }, onChange: v }, null, 8, ["modelValue", "disabled-value"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} };
export {
  G as default
};
