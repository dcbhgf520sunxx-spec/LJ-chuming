import { ref as b } from "vue";
import { watch as B } from "vue";
import { nextTick as F } from "vue";
import { resolveComponent as _ } from "vue";
import { openBlock as N } from "vue";
import { createBlock as R } from "vue";
import { withCtx as u } from "vue";
import { createVNode as t } from "vue";
import { unref as l } from "vue";
import { createTextVNode as q } from "vue";
import { createElementVNode as y } from "vue";
import { createElementBlock as E } from "vue";
import { Fragment as P } from "vue";
import { renderList as H } from "vue";
import { withDirectives as K } from "vue";
import { vShow as j } from "vue";
import { ElMessage as C } from "element-plus";
import { ElFormItem as D } from "element-plus";
import { ElInput as $ } from "element-plus";
import { ElInputNumber as G } from "element-plus";
import { ElForm as J } from "element-plus";
import { _ as Q, am as p, ao as W, V as X, ap as Y, fj as Z } from "../../../../../shared/runtime.js";
const ee = { class: "process-container" }, se = { class: "process-box" }, le = { __name: "form", props: { boundAllClassifyIds: { type: Array, default: () => [] } }, setup(I) {
  const h = I, c = b([]), v = b(), i = b([]), w = { id: void 0, name: "", basicClass: p.MATERIAL.V, type: void 0, sort: void 0, list: [] }, { crud: d, form: s, CRUD: f } = W(w, v), T = { name: [{ required: true, message: "请填写类型名称", trigger: "blur" }, { min: 1, max: 30, message: "长度在 1 到 30 个字符", trigger: "blur" }], classifyIds: [{ required: true, message: "请选择科目", trigger: "change" }], type: [{ required: true, message: "请选择所属类型", trigger: "change" }], list: [{ required: true, message: "请填写编号" }, { validator: (a, e, r) => {
    if (e && e.length) {
      for (const n in e) e[n].serialNumber ? r() : r(new Error("请填写编号"));
      r();
    } else r(new Error("请填写编号"));
  }, trigger: "change" }] }, L = b([p.MATERIAL]);
  B(() => s.basicClass, (a, e) => {
    e === p.STEEL_PLATE.V && (i.value = [], s.list = []), a === p.STEEL_PLATE.V && e && e !== p.STEEL_PLATE.V && (i.value = [], s.list = []), a && e && (s.classifyIds = []);
  });
  function k() {
    s.list.push({ serialNumber: void 0 });
  }
  function A(a) {
    s.list.splice(a, 1);
  }
  function U(a, e) {
    const r = i.value.find((n) => n.index === e);
    if (r) if (a.serialNumber) {
      if (r.serialNumber === a.serialNumber) return;
      i.value.findIndex((n) => n.serialNumber === a.serialNumber) > -1 ? (C({ message: "编号已存在，请重新填写", type: "error" }), a.serialNumber = void 0, r.serialNumber = void 0) : r.serialNumber = a.serialNumber;
    } else r.serialNumber = void 0;
    else a.serialNumber && (i.value.findIndex((n) => n.serialNumber === a.serialNumber) > -1 && (C({ message: "编号已存在，请重新填写", type: "error" }), s.list[e].serialNumber = void 0), i.value.push({ serialNumber: a.serialNumber, index: e }));
  }
  return f.HOOK.beforeSubmit = () => {
    s.auxiliarySerialNumberList = [], s.list.map((a) => {
      s.auxiliarySerialNumberList.push(a.serialNumber);
    });
  }, f.HOOK.beforeToAdd = () => {
    i.value = [];
  }, f.HOOK.beforeToEdit = () => {
    i.value = [], s.list.map((a, e) => {
      i.value.push({ serialNumber: a.serialNumber, index: e });
    });
  }, f.HOOK.beforeToCU = () => {
    F(() => {
      c.value = X(h.boundAllClassifyIds), s.classifyIds && s.classifyIds.forEach((a) => {
        const e = c.value.indexOf(a);
        e !== -1 && c.value.splice(e, 1);
      });
    });
  }, (a, e) => {
    const r = _("common-button"), n = _("common-radio-button"), m = D, V = $, z = _("common-select"), O = G, M = J, S = _("common-drawer");
    return N(), R(S, { "append-to-body": "", "close-on-click-modal": false, "before-close": l(d).cancelCU, visible: l(d).status.cu > 0, title: l(d).status.title, "wrapper-closable": false, size: "800px" }, { titleRight: u(() => [t(r, { loading: l(d).status.cu === 2, type: "primary", size: "default", onClick: l(d).submitCU }, { default: u(() => e[5] || (e[5] = [q("确认")])), _: 1, __: [5] }, 8, ["loading", "onClick"])]), content: u(() => [e[7] || (e[7] = y("span", { style: { "font-size": "12px", color: "red" } }, "*配套件的编号不得与构件、部件、零件重名", -1)), t(M, { ref_key: "formRef", ref: v, model: l(s), rules: T, size: "default", "label-width": "140px", style: {} }, { default: u(() => [t(m, { label: "配套件科目匹配", prop: "classifyIds" }, { default: u(() => [t(n, { modelValue: l(s).basicClass, "onUpdate:modelValue": e[0] || (e[0] = (o) => l(s).basicClass = o), options: L.value, type: "enum", size: "default", style: { "margin-right": "5px" } }, null, 8, ["modelValue", "options"]), e[6] || (e[6] = y("br", null, null, -1)), t(Y, { modelValue: l(s).classifyIds, "onUpdate:modelValue": e[1] || (e[1] = (o) => l(s).classifyIds = o), "basic-class": l(s).basicClass, disabled: !l(s).basicClass, multiple: "", "collapse-tags": false, separator: " > ", clearable: "", disabledVal: c.value, placeholder: "请选择科目", size: "default", style: { width: "270px" } }, null, 8, ["modelValue", "basic-class", "disabled", "disabledVal"])]), _: 1, __: [6] }), t(m, { label: "类型命名", prop: "name" }, { default: u(() => [t(V, { modelValue: l(s).name, "onUpdate:modelValue": e[2] || (e[2] = (o) => l(s).name = o), modelModifiers: { trim: true }, type: "text", placeholder: "类型命名", style: { width: "270px" }, maxlength: "30" }, null, 8, ["modelValue"])]), _: 1 }), t(m, { label: "所属类型", prop: "type" }, { default: u(() => [t(z, { modelValue: l(s).type, "onUpdate:modelValue": e[3] || (e[3] = (o) => l(s).type = o), options: l(Z).ENUM, type: "enum", size: "default", class: "filter-item", placeholder: "所属类型选择", style: { width: "270px" } }, null, 8, ["modelValue", "options"])]), _: 1 }), t(m, { label: "排序", prop: "sort" }, { default: u(() => [t(O, { modelValue: l(s).sort, "onUpdate:modelValue": e[4] || (e[4] = (o) => l(s).sort = o), modelModifiers: { number: true }, min: 1, max: 999, step: 1, "controls-position": "right", style: { width: "270px" } }, null, 8, ["modelValue"])]), _: 1 }), t(m, { label: "编号", prop: "list" }, { default: u(() => [y("div", ee, [y("div", se, [(N(true), E(P, null, H(l(s).list, (o, g) => (N(), E("div", { key: g, class: "process-drawer" }, [t(V, { modelValue: o.serialNumber, "onUpdate:modelValue": (x) => o.serialNumber = x, type: "text", placeholder: "编号", style: { width: "270px", "margin-right": "5px" }, onBlur: (x) => U(o, g) }, null, 8, ["modelValue", "onUpdate:modelValue", "onBlur"]), K(t(r, { icon: "el-icon-delete", size: "default", type: "danger", style: { "margin-left": "6px" }, onClick: (x) => A(g) }, null, 8, ["onClick"]), [[j, l(s).list && l(s).list.length > 1]])]))), 128))]), t(r, { icon: "el-icon-plus", size: "default", type: "success", style: { margin: "0 0 12px 6px" }, onClick: k })])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} }, oe = Q(le, [["__scopeId", "data-v-e54495b1"]]);
export {
  oe as default
};
