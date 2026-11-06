import { ref as m } from "vue";
import { computed as T } from "vue";
import { watch as v } from "vue";
import { onMounted as Q } from "vue";
import { onUnmounted as W } from "vue";
import { resolveComponent as k } from "vue";
import { openBlock as w } from "vue";
import { createBlock as C } from "vue";
import { withCtx as r } from "vue";
import { createVNode as l } from "vue";
import { unref as t } from "vue";
import { createTextVNode as X } from "vue";
import { createCommentVNode as S } from "vue";
import { createElementVNode as z } from "vue";
import { ElFormItem as Y } from "element-plus";
import { ElCascader as ee } from "element-plus";
import { ElCheckbox as te } from "element-plus";
import { ElSlider as se } from "element-plus";
import { ElForm as ae } from "element-plus";
import { l as f, _ as oe, p9 as g, ao as le, fa as ne, es as P, pb as re, oZ as b, V as de } from "../../../../../../shared/runtime.js";
import { u as ie } from "../../../../../../modules/index-9d220fe1.js";
function ue(n) {
  return f({ module: "mes", url: "inspect/config/page", method: "get", params: n });
}
function pe(n) {
  return f({ module: "mes", url: "inspect/config/save", method: "post", data: n });
}
function ce(n) {
  return f({ module: "mes", url: "inspect/config/update", method: "put", data: n });
}
function me(n) {
  return f({ module: "mes", url: `inspect/config/delete/${n}`, method: "delete", data: n });
}
function fe(n) {
  return f({ module: "mes", cancleKey: false, url: "team/workshop/process/leader", method: "get", params: n });
}
function _e(n) {
  return f({ module: "mes", url: "inspect/config/changeState", method: "put", data: n });
}
const Ee = { get: ue, add: pe, edit: ce, del: me };
const ye = { class: "checkbox" }, Ie = { __name: "form", props: { workshopList: Array }, setup(n) {
  const U = m(), y = m([]), x = m([]), V = m([]), I = m(false), _ = m([]), F = { workshopId: "", taskTypeEnum: "", artifactType: "", processId: "", classificationId: [], teamIds: [], inspectUserIds: [], inspectType: g.TEAM.V, firstInspectRate: void 0 }, { crud: p, form: e, CRUD: A } = le(F, U), E = T(() => p.status.edit >= 1), L = T(() => ({ value: "id", label: "name", children: "children", expandTrigger: "hover", emitPath: false, multiple: true })), B = T(() => p.query.mesProductEnum === ne.BRIDGE.V ? [P.SMALL.V] : []), M = T(() => V.value.filter((a) => a.workshopId === e.workshopId && a.taskTypeEnum === e.taskTypeEnum)), j = { workshopId: [{ required: true, message: "请选择车间", trigger: "change" }], taskTypeEnum: [{ required: true, message: "请选择类型", trigger: "change" }], artifactType: [{ required: true, message: "请选择主次类型", trigger: "change" }], processId: [{ required: true, message: "请选择工序", trigger: "change" }], classificationId: [{ required: true, message: "请选择零件类型", trigger: "change" }], teamIds: [{ required: true, message: "请选择零件班组", trigger: "change" }], inspectUserIds: [{ required: true, message: "请选择质检人", trigger: "change" }], inspectType: [{ required: true, message: "请选择质检方式", trigger: "change" }], firstInspectRate: [{ required: e.inspectType === g.INSPECTION.V, message: "请选择检查率", trigger: "change" }] }, N = async (a, s) => {
    var d, u, i, h;
    a !== b.ARTIFACT.V ? y.value = (u = (d = _.value) == null ? void 0 : d.content) == null ? void 0 : u.filter((c) => c.taskTypeEnum === a) : y.value = (h = (i = _.value) == null ? void 0 : i.content) == null ? void 0 : h.filter((c) => c.taskTypeEnum === a && c.artifactType === s);
  };
  function R() {
    var s;
    let a = de(V.value);
    a = a.filter((d) => d.taskTypeEnum === e.taskTypeEnum && d.processId === e.processId && d.workshopId === e.workshopId), a.forEach((d) => {
      d.children = d.prodLineInfos, d.prodLineInfos.forEach((u) => {
        u.children = u.teamInfo;
      });
    }), x.value = (s = a[0]) == null ? void 0 : s.children;
  }
  const D = v(() => [e.workshopId, e.taskTypeEnum, e.processId, e.artifactType], () => {
    p.status.add && (e.workshopId || (e.processId = "", e.teamIds = []), e.workshopId && e.taskTypeEnum && e.processId && (e.classificationId = [], R()), e.taskTypeEnum && N(e.taskTypeEnum, e.artifactType));
  }), K = () => {
    e.inspectType === g.INSPECTION.V ? e.firstInspectRate = 20 : e.firstInspectRate = void 0;
  }, q = () => {
    e.processId = "", I.value = false, e.classificationId = [];
  };
  v(() => e.classificationId, (a) => {
    var s;
    a && a.length === ((s = y.value) == null ? void 0 : s.length) ? I.value = true : I.value = false;
  }, { immediate: true, deep: true }), v(() => p.query.mesProductEnum, () => {
    O();
  });
  function H(a) {
    a ? e.classificationId = y.value.map((s) => s.id) : e.classificationId = [];
  }
  const O = async () => {
    _.value = await re({ mesProductEnum: p.query.mesProductEnum });
  };
  return Q(() => {
    O(), fe().then((a) => {
      V.value = a == null ? void 0 : a.content;
    });
  }), W(() => {
    D();
  }), A.HOOK.beforeToEdit = (a, s) => {
    N(s.taskTypeEnum, s.artifactType), R();
  }, A.HOOK.beforeSubmit = (a) => {
    a.form.teamLink = a.form.teamIds, e.mesProductEnum = a.query.mesProductEnum;
  }, (a, s) => {
    const d = k("common-button"), u = k("common-select"), i = Y, h = k("common-select-v2"), c = ee, G = te, Z = se, $ = ae, J = k("common-dialog");
    return w(), C(J, { "close-on-click-modal": false, "before-close": t(p).cancelCU, visible: t(p).status.cu > 0, title: t(p).status.title, width: "500px" }, { titleRight: r(() => [l(d, { loading: t(p).status.cu === 2, type: "primary", size: "default", onClick: t(p).submitCU }, { default: r(() => s[10] || (s[10] = [X("确认")])), _: 1, __: [10] }, 8, ["loading", "onClick"])]), default: r(() => [l($, { ref_key: "formRef", ref: U, model: t(e), rules: j, size: "default", "label-width": "130px" }, { default: r(() => [l(i, { label: "车间", prop: "workshopId" }, { default: r(() => [l(u, { modelValue: t(e).workshopId, "onUpdate:modelValue": s[0] || (s[0] = (o) => t(e).workshopId = o), options: n.workshopList, type: "other", "data-structure": { key: "id", label: "name", value: "id" }, class: "filter-item", clearable: "", style: { width: "270px" }, placeholder: "请选择车间" }, null, 8, ["modelValue", "options"])]), _: 1 }), l(i, { label: "类型", prop: "taskTypeEnum" }, { default: r(() => [l(u, { modelValue: t(e).taskTypeEnum, "onUpdate:modelValue": s[1] || (s[1] = (o) => t(e).taskTypeEnum = o), options: t(b).ENUM, type: "enum", disabled: E.value, size: "default", clearable: "", placeholder: "请选择类型", style: { width: "270px" }, onChange: q }, null, 8, ["modelValue", "options", "disabled"])]), _: 1 }), t(e).taskTypeEnum === t(b).ARTIFACT.V ? (w(), C(i, { key: 0, label: "主次类型", prop: "artifactType" }, { default: r(() => [l(h, { modelValue: t(e).artifactType, "onUpdate:modelValue": s[2] || (s[2] = (o) => t(e).artifactType = o), options: t(P).ENUM, default: true, disabled: E.value, disabledVal: B.value, clearable: "", type: "enum", size: "default", style: { width: "270px" }, onChange: q }, null, 8, ["modelValue", "options", "disabled", "disabledVal"])]), _: 1 })) : S("", true), l(i, { label: "选择工序", prop: "processId" }, { default: r(() => [l(u, { modelValue: t(e).processId, "onUpdate:modelValue": s[3] || (s[3] = (o) => t(e).processId = o), options: M.value, "data-structure": { key: "processId", label: "processName", value: "processId" }, clearable: "", filterable: "", type: "other", size: "default", placeholder: "请选择工序", style: { width: "270px" }, disabled: !t(e).taskTypeEnum || !t(e).workshopId || E.value }, null, 8, ["modelValue", "options", "disabled"])]), _: 1 }), l(i, { label: "生产线/班组", prop: "teamIds" }, { default: r(() => [l(c, { modelValue: t(e).teamIds, "onUpdate:modelValue": s[4] || (s[4] = (o) => t(e).teamIds = o), options: x.value, "check-strictly": "", "show-all-levels": false, props: L.value, separator: " > ", clearable: "", size: "default", class: "filter-item", style: { width: "270px" }, placeholder: "请选择生产线/班组", disabled: !t(e).processId }, null, 8, ["modelValue", "options", "props", "disabled"])]), _: 1 }), l(i, { label: "零构件类型", prop: "classificationId" }, { default: r(() => [l(u, { modelValue: t(e).classificationId, "onUpdate:modelValue": s[6] || (s[6] = (o) => t(e).classificationId = o), options: y.value, multiple: true, dataStructure: { key: "id", label: "className", value: "id" }, size: "default", clearable: "", placeholder: "请选择零构件类型", class: "filter-item", disabled: !t(e).taskTypeEnum || t(e).taskTypeEnum === t(b).ARTIFACT.V && t(e).artifactType === "", style: { width: "270px" } }, { all: r(() => [z("div", ye, [l(G, { modelValue: I.value, "onUpdate:modelValue": s[5] || (s[5] = (o) => I.value = o), onChange: H }, null, 8, ["modelValue"]), s[11] || (s[11] = z("span", { class: "name" }, "全选", -1))])]), _: 1 }, 8, ["modelValue", "options", "disabled"])]), _: 1 }), l(i, { label: "质检人", prop: "inspectUserIds" }, { default: r(() => [l(t(ie), { modelValue: t(e).inspectUserIds, "onUpdate:modelValue": s[7] || (s[7] = (o) => t(e).inspectUserIds = o), size: "default", multiple: "", clearable: "", placeholder: "请选择质检人", style: { width: "270px" } }, null, 8, ["modelValue"])]), _: 1 }), l(i, { label: "质检方式", prop: "inspectType" }, { default: r(() => [l(u, { modelValue: t(e).inspectType, "onUpdate:modelValue": s[8] || (s[8] = (o) => t(e).inspectType = o), options: t(g).ENUM, default: true, type: "enum", size: "default", placeholder: "请选择质检方式", style: { width: "270px" }, onChange: K }, null, 8, ["modelValue", "options"])]), _: 1 }), t(e).inspectType === t(g).INSPECTION.V ? (w(), C(i, { key: 1, label: "质检率", prop: "firstInspectRate" }, { default: r(() => [l(Z, { modelValue: t(e).firstInspectRate, "onUpdate:modelValue": s[9] || (s[9] = (o) => t(e).firstInspectRate = o), style: { width: "270px" } }, null, 8, ["modelValue"])]), _: 1 })) : S("", true)]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} }, ge = oe(Ie, [["__scopeId", "data-v-1653f253"]]), ve = Object.freeze(Object.defineProperty({ __proto__: null, default: ge }, Symbol.toStringTag, { value: "Module" }));
export {
  Ee as c,
  _e as e,
  ve as f,
  ge as m
};
