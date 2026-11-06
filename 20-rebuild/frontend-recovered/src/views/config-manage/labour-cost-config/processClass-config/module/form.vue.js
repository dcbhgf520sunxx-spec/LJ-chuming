import { ref as u } from "vue";
import { watch as W } from "vue";
import { computed as j } from "vue";
import { resolveComponent as g } from "vue";
import { openBlock as d } from "vue";
import { createBlock as C } from "vue";
import { withCtx as r } from "vue";
import { createVNode as o } from "vue";
import { unref as t } from "vue";
import { createTextVNode as Q } from "vue";
import { createElementBlock as f } from "vue";
import { Fragment as L } from "vue";
import { renderList as v } from "vue";
import { createElementVNode as y } from "vue";
import { withDirectives as k } from "vue";
import { vShow as E } from "vue";
import { ElInput as Y } from "element-plus";
import { ElFormItem as G } from "element-plus";
import { ElOption as J } from "element-plus";
import { ElSelect as X } from "element-plus";
import { ElForm as Z } from "element-plus";
import { _ as ee, ao as te, eu as w, es as ne, ev as ae, a3 as oe } from "../../../../../shared/runtime.js";
const se = { class: "process-container" }, le = { class: "process-box" }, ie = { class: "process-container" }, re = { class: "process-box" }, de = { __name: "form", setup(ce) {
  const h = u(), I = u([]), x = u(), O = u(false), U = u(false), z = { classification: "", artifactType: "", nameIndexList: [], typeIndexList: [], nameIndexNameInfoList: [], typeIndexNameInfoList: [] }, { crud: m, form: e, CRUD: b } = te(z, h);
  W(() => e.artifactType, (a) => {
  }, { deep: true });
  const S = { classification: [{ required: true, message: "输入构件类型名称", trigger: "change" }], artifactType: [{ required: true, message: "选择主次构件", trigger: "change" }], nameIndexNameInfoList: [{ required: true, message: "请选择构件名称" }, { validator: (a, n, s) => {
    if (n && n.length) {
      for (const p in n) n[p].name || s(new Error("请选择构件名称"));
      s();
    } else s(new Error("请选择构件名称"));
  }, trigger: "change" }], typeIndexNameInfoList: [{ required: true, message: "请选择截面类型" }, { validator: (a, n, s) => {
    if (n && n.length) {
      for (const p in n) n[p].name || s(new Error("请选择截面类型"));
      s();
    } else s(new Error("请选择截面类型"));
  }, trigger: "change" }] }, N = j(() => x.value[w.SECTION_TYPE_ENUM.V][0].sectionWarehouseConfigDTOList);
  b.HOOK.beforeToEdit = (a, n) => {
    n.artifactType = a.form.artifactType, T();
  };
  const T = () => {
    var a;
    I.value = (a = x.value[w.PRODUCT_NAME.V]) == null ? void 0 : a.filter((n) => n.productClassificationEnum === e.artifactType)[0].sectionWarehouseConfigDTOList;
  };
  async function F() {
    try {
      const a = await ae({ productType: oe.ARTIFACT.V }) || {};
      x.value = a;
    } catch (a) {
      console.log("error", a);
    }
  }
  function R() {
    m.cancelCU(), O.value = false, U.value = false;
  }
  F();
  function P(a) {
    e.nameIndexNameInfoList.splice(a, 1);
  }
  function q(a) {
    e.typeIndexNameInfoList.splice(a, 1);
  }
  function A() {
    e.nameIndexNameInfoList.push({});
  }
  function B(a) {
    e.typeIndexNameInfoList.push({});
  }
  b.HOOK.beforeSubmit = () => {
    e.nameIndexList = e.nameIndexNameInfoList.map((a) => a.name), e.typeIndexList = e.typeIndexNameInfoList.map((a) => a.name);
  };
  function D() {
    e.nameIndexNameInfoList = [];
  }
  return (a, n) => {
    const s = g("common-button"), p = Y, _ = G, M = J, $ = X, V = g("common-select"), H = Z, K = g("common-dialog");
    return d(), C(K, { "close-on-click-modal": false, "before-close": R, visible: t(m).status.cu > 0, title: t(m).status.title, width: "600px" }, { titleRight: r(() => [o(s, { loading: t(m).status.cu === 2, type: "primary", size: "default", onClick: t(m).submitCU }, { default: r(() => n[3] || (n[3] = [Q("确认")])), _: 1, __: [3] }, 8, ["loading", "onClick"])]), default: r(() => [o(H, { ref_key: "formRef", ref: h, model: t(e), rules: S, size: "default", "label-width": "100px" }, { default: r(() => [o(_, { label: "构件分类", prop: "classification" }, { default: r(() => [o(p, { modelValue: t(e).classification, "onUpdate:modelValue": n[0] || (n[0] = (l) => t(e).classification = l), maxlength: "50", placeholder: "输入构件类型名称", style: { width: "270px" } }, null, 8, ["modelValue"])]), _: 1 }), o(_, { label: "主次构件", prop: "artifactType" }, { default: r(() => [o($, { modelValue: t(e).artifactType, "onUpdate:modelValue": n[2] || (n[2] = (l) => t(e).artifactType = l), style: { width: "270px" }, placeholder: "请选择", onChange: T }, { default: r(() => [(d(true), f(L, null, v(t(ne).ENUM, (l) => (d(), C(M, { key: l.V, label: l.L, value: l.V, onClick: n[1] || (n[1] = (c) => D()) }, null, 8, ["label", "value"]))), 128))]), _: 1 }, 8, ["modelValue"])]), _: 1 }), o(_, { label: "构件名称", prop: "nameIndexNameInfoList" }, { default: r(() => [y("div", se, [y("div", le, [(d(true), f(L, null, v(t(e).nameIndexNameInfoList, (l, c) => (d(), f("div", { key: c, class: "process-drawer" }, [o(V, { modelValue: l.name, "onUpdate:modelValue": (i) => l.name = i, options: I.value, dataStructure: { key: "id", label: "name", value: "name" }, disabled: t(e).artifactType === "", disabledVal: t(e).nameIndexNameInfoList.map((i) => i.name), size: "default", style: { width: "270px" } }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "disabled", "disabledVal"]), k(o(s, { icon: "el-icon-delete", size: "default", type: "danger", style: { "margin-left": "6px" }, onClick: (i) => P(c) }, null, 8, ["onClick"]), [[E, t(e).nameIndexNameInfoList && t(e).nameIndexNameInfoList.length > 1]])]))), 128))]), o(s, { icon: "el-icon-plus", size: "default", type: "success", disabled: t(e).nameIndexNameInfoList.length === I.value.length || !t(e).artifactType, style: { margin: "0 0 12px 6px" }, onClick: A }, null, 8, ["disabled"])])]), _: 1 }), o(_, { label: "截面类型", prop: "typeIndexNameInfoList" }, { default: r(() => [y("div", ie, [y("div", re, [(d(true), f(L, null, v(t(e).typeIndexNameInfoList, (l, c) => (d(), f("div", { key: c, class: "process-drawer" }, [o(V, { modelValue: l.name, "onUpdate:modelValue": (i) => l.name = i, options: N.value, dataStructure: { key: "id", label: "name", value: "name" }, disabledVal: t(e).typeIndexNameInfoList.map((i) => i.name), size: "default", style: { width: "270px" } }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "disabledVal"]), k(o(s, { icon: "el-icon-delete", size: "default", type: "danger", style: { "margin-left": "6px" }, onClick: (i) => q(c) }, null, 8, ["onClick"]), [[E, t(e).typeIndexNameInfoList && t(e).typeIndexNameInfoList.length > 1]])]))), 128))]), o(s, { icon: "el-icon-plus", size: "default", type: "success", disabled: t(e).typeIndexNameInfoList.length === N.value.length || !t(e).artifactType, style: { margin: "0 0 12px 6px" }, onClick: B }, null, 8, ["disabled"])])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["visible", "title"]);
  };
} }, _e = ee(de, [["__scopeId", "data-v-ff9fe7cb"]]);
export {
  _e as default
};
