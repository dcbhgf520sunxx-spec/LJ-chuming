import { ref as v } from "vue";
import { resolveComponent as p } from "vue";
import { openBlock as N } from "vue";
import { createBlock as x } from "vue";
import { withCtx as o } from "vue";
import { createElementVNode as g } from "vue";
import { createVNode as a } from "vue";
import { withModifiers as R } from "vue";
import { createTextVNode as U } from "vue";
import { unref as n } from "vue";
import { isRef as k } from "vue";
import { ElNotification as B } from "element-plus";
import { ElFormItem as S } from "element-plus";
import { ElForm as z } from "element-plus";
import { u as A, dK as y, dJ as C } from "../../../../../shared/runtime.js";
import { a as D } from "../../../../../modules/user-template-config-16e71de8.js";
import { u as q } from "../../../../../modules/index-9d220fe1.js";
import "../../../../../modules/use-users-4d979987.js";
const F = { style: { float: "right" } }, M = { class: "form" }, L = { __name: "form", props: { visible: { type: Boolean, default: false }, isEdit: { type: Boolean, default: false }, detailData: { type: Object, default: () => {
} }, disabledArr: { type: Array, default: () => [] } }, emits: ["update:visible", "refresh"], setup(c, { emit: V }) {
  const E = V, m = v(), b = v(false), s = c, { visible: f, handleClose: _ } = A({ emit: E, props: s, field: "visible", showHook: T }), l = v({ id: void 0, crmPersonTemplateEnum: void 0, userIds: [], crmPersonOperateTypeEnum: y.ROUTINE_OPERATIONS.V });
  async function T() {
    var i, e, u, d;
    await ((i = m.value) == null ? void 0 : i.resetFields()), await ((e = m.value) == null ? void 0 : e.clearValidate()), s.isEdit ? (l.value = s.detailData, l.value.userIds = (d = (u = s.detailData) == null ? void 0 : u.userSimpleInfoDTOS) == null ? void 0 : d.map((r) => r.userId)) : l.value = { crmPersonTemplateEnum: void 0, userIds: [], crmPersonOperateTypeEnum: y.ROUTINE_OPERATIONS.V };
  }
  const I = { crmPersonTemplateEnum: [{ required: true, message: "请选择名称类型", trigger: "change" }], userIds: [{ required: true, message: "请选择人员", trigger: "change" }], crmPersonOperateTypeEnum: [{ required: true, message: "请选择操作方式", trigger: "change" }] };
  async function O() {
    if (await m.value.validate()) try {
      b.value = true, await D({ ...l.value }), B({ title: `${s.isEdit ? "编辑" : "新增"}成功`, type: "success" }), _(), E("refresh");
    } catch (e) {
      console.log("人员模板配置失败", e);
    } finally {
      b.value = false;
    }
  }
  return (i, e) => {
    const u = p("common-button"), d = p("common-select"), r = S, P = p("common-radio"), h = z, w = p("common-dialog");
    return N(), x(w, { "append-to-body": "", "close-on-click-modal": false, "before-close": n(_), modelValue: n(f), "onUpdate:modelValue": e[3] || (e[3] = (t) => k(f) ? f.value = t : null), title: `${c.isEdit ? "编辑" : "新增"}人员模板配置`, width: "500px", top: "10vh" }, { titleRight: o(() => [g("span", F, [a(u, { type: "primary", size: "default", onClick: R(O, ["stop"]) }, { default: o(() => e[4] || (e[4] = [U("提交")])), _: 1, __: [4] })])]), default: o(() => [g("div", M, [a(h, { ref_key: "formRef", ref: m, model: l.value, rules: I, size: "default", "label-width": "90px", class: "demo-form" }, { default: o(() => [a(r, { label: "名称类型", prop: "crmPersonTemplateEnum" }, { default: o(() => [a(d, { modelValue: l.value.crmPersonTemplateEnum, "onUpdate:modelValue": e[0] || (e[0] = (t) => l.value.crmPersonTemplateEnum = t), options: n(C).ENUM, type: "enum", class: "filter-item", clearable: "", placeholder: "选择名称类型", disabledVal: c.disabledArr, style: { width: "300px" } }, null, 8, ["modelValue", "options", "disabledVal"])]), _: 1 }), a(r, { label: "人员范围", prop: "userIds" }, { default: o(() => [a(n(q), { ref: "leaderSelectRef", modelValue: l.value.userIds, "onUpdate:modelValue": e[1] || (e[1] = (t) => l.value.userIds = t), "collapse-tags": "", "collapse-tags-tooltip": "", "max-collapse-tags": 2, filterable: "", clearable: "", multiple: "", size: "default", placeholder: "选择人员", style: { width: "300px" } }, null, 8, ["modelValue"])]), _: 1 }), a(r, { label: "操作方式", prop: "crmPersonOperateTypeEnum" }, { default: o(() => [a(P, { class: "filter-item", modelValue: l.value.crmPersonOperateTypeEnum, "onUpdate:modelValue": e[2] || (e[2] = (t) => l.value.crmPersonOperateTypeEnum = t), options: n(y).ENUM, type: "enum", size: "default" }, null, 8, ["modelValue", "options"])]), _: 1 })]), _: 1 }, 8, ["model"])])]), _: 1 }, 8, ["before-close", "modelValue", "title"]);
  };
} };
export {
  L as default
};
