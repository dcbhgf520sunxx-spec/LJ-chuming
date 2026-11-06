import { ref as b } from "vue";
import { watch as B } from "vue";
import { nextTick as F } from "vue";
import { resolveComponent as x } from "vue";
import { openBlock as N } from "vue";
import { createBlock as M } from "vue";
import { withCtx as u } from "vue";
import { createVNode as t } from "vue";
import { unref as a } from "vue";
import { createTextVNode as R } from "vue";
import { createElementVNode as _ } from "vue";
import { createElementBlock as V } from "vue";
import { Fragment as P } from "vue";
import { renderList as q } from "vue";
import { withDirectives as H } from "vue";
import { vShow as K } from "vue";
import { ElMessage as E } from "element-plus";
import { ElFormItem as D } from "element-plus";
import { ElInput as $ } from "element-plus";
import { ElInputNumber as j } from "element-plus";
import { ElForm as G } from "element-plus";
import { _ as J, am as m, ao as Q, V as W, ap as X } from "../../../../../../shared/runtime.js";
const Y = { class: "process-container" }, Z = { class: "process-box" }, ee = { __name: "form", props: { boundAllClassifyIds: { type: Array, default: () => [] } }, setup(I) {
  const w = I, c = b([]), v = b(), i = b([]), h = { id: void 0, name: "", basicClass: m.MATERIAL.V, sort: void 0, list: [] }, { crud: d, form: s, CRUD: p } = Q(h, v), L = { name: [{ required: true, message: "请填写类型名称", trigger: "blur" }, { min: 1, max: 30, message: "长度在 1 到 30 个字符", trigger: "blur" }], classifyIds: [{ required: true, message: "请选择科目", trigger: "change" }], list: [{ required: true, message: "请填写编号" }, { validator: (l, e, r) => {
    if (e && e.length) {
      for (const n in e) e[n].serialNumber ? r() : r(new Error("请填写编号"));
      r();
    } else r(new Error("请填写编号"));
  }, trigger: "change" }] }, T = b([m.MATERIAL]);
  B(() => s.basicClass, (l, e) => {
    e === m.STEEL_PLATE.V && (i.value = [], s.list = []), l === m.STEEL_PLATE.V && e && e !== m.STEEL_PLATE.V && (i.value = [], s.list = []), l && e && (s.classifyIds = []);
  });
  function k() {
    s.list.push({ serialNumber: void 0 });
  }
  function A(l) {
    s.list.splice(l, 1);
  }
  function O(l, e) {
    const r = i.value.find((n) => n.index === e);
    if (r) if (l.serialNumber) {
      if (r.serialNumber === l.serialNumber) return;
      i.value.findIndex((n) => n.serialNumber === l.serialNumber) > -1 ? (E({ message: "编号已存在，请重新填写", type: "error" }), l.serialNumber = void 0, r.serialNumber = void 0) : r.serialNumber = l.serialNumber;
    } else r.serialNumber = void 0;
    else l.serialNumber && (i.value.findIndex((n) => n.serialNumber === l.serialNumber) > -1 && (E({ message: "编号已存在，请重新填写", type: "error" }), s.list[e].serialNumber = void 0), i.value.push({ serialNumber: l.serialNumber, index: e }));
  }
  return p.HOOK.beforeSubmit = () => {
    s.auxiliarySerialNumberList = [], s.list.map((l) => {
      s.auxiliarySerialNumberList.push(l.serialNumber);
    });
  }, p.HOOK.beforeToAdd = () => {
    i.value = [];
  }, p.HOOK.beforeToEdit = () => {
    i.value = [], s.list.map((l, e) => {
      i.value.push({ serialNumber: l.serialNumber, index: e });
    });
  }, p.HOOK.beforeToCU = () => {
    F(() => {
      c.value = W(w.boundAllClassifyIds), s.classifyIds && s.classifyIds.forEach((l) => {
        const e = c.value.indexOf(l);
        e !== -1 && c.value.splice(e, 1);
      });
    });
  }, (l, e) => {
    const r = x("common-button"), n = x("common-radio-button"), f = D, C = $, U = j, z = G, S = x("common-drawer");
    return N(), M(S, { "append-to-body": "", "close-on-click-modal": false, "before-close": a(d).cancelCU, visible: a(d).status.cu > 0, title: a(d).status.title, "wrapper-closable": false, size: "800px" }, { titleRight: u(() => [t(r, { loading: a(d).status.cu === 2, type: "primary", size: "default", onClick: a(d).submitCU }, { default: u(() => e[4] || (e[4] = [R("确认")])), _: 1, __: [4] }, 8, ["loading", "onClick"])]), content: u(() => [e[6] || (e[6] = _("span", { style: { "font-size": "12px", color: "red" } }, "*配套件的编号不得与分段、单元、零件重名", -1)), t(z, { ref_key: "formRef", ref: v, model: a(s), rules: L, size: "default", "label-width": "140px", style: {} }, { default: u(() => [t(f, { label: "零件科目匹配", prop: "classifyIds" }, { default: u(() => [t(n, { modelValue: a(s).basicClass, "onUpdate:modelValue": e[0] || (e[0] = (o) => a(s).basicClass = o), options: T.value, type: "enum", size: "default", style: { "margin-bottom": "5px" } }, null, 8, ["modelValue", "options"]), e[5] || (e[5] = _("br", null, null, -1)), t(X, { modelValue: a(s).classifyIds, "onUpdate:modelValue": e[1] || (e[1] = (o) => a(s).classifyIds = o), "basic-class": a(s).basicClass, disabled: !a(s).basicClass, multiple: "", "collapse-tags": false, separator: " > ", clearable: "", disabledVal: c.value, placeholder: "请选择科目", size: "default", style: { width: "270px" } }, null, 8, ["modelValue", "basic-class", "disabled", "disabledVal"])]), _: 1, __: [5] }), t(f, { label: "类型命名", prop: "name" }, { default: u(() => [t(C, { modelValue: a(s).name, "onUpdate:modelValue": e[2] || (e[2] = (o) => a(s).name = o), modelModifiers: { trim: true }, type: "text", placeholder: "类型命名", style: { width: "270px" }, maxlength: "30" }, null, 8, ["modelValue"])]), _: 1 }), t(f, { label: "排序", prop: "sort" }, { default: u(() => [t(U, { modelValue: a(s).sort, "onUpdate:modelValue": e[3] || (e[3] = (o) => a(s).sort = o), modelModifiers: { number: true }, min: 1, max: 999, step: 1, "controls-position": "right", style: { width: "270px" } }, null, 8, ["modelValue"])]), _: 1 }), t(f, { label: "编号", prop: "list" }, { default: u(() => [_("div", Y, [_("div", Z, [(N(true), V(P, null, q(a(s).list, (o, y) => (N(), V("div", { key: y, class: "process-drawer" }, [t(C, { modelValue: o.serialNumber, "onUpdate:modelValue": (g) => o.serialNumber = g, type: "text", placeholder: "编号", style: { width: "270px", "margin-right": "5px" }, onBlur: (g) => O(o, y) }, null, 8, ["modelValue", "onUpdate:modelValue", "onBlur"]), H(t(r, { icon: "el-icon-delete", size: "default", type: "danger", style: { "margin-left": "6px" }, onClick: (g) => A(y) }, null, 8, ["onClick"]), [[K, a(s).list && a(s).list.length > 1]])]))), 128))]), t(r, { icon: "el-icon-plus", size: "default", type: "success", style: { margin: "0 0 12px 6px" }, onClick: k })])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} }, re = J(ee, [["__scopeId", "data-v-bb3843c5"]]);
export {
  re as default
};
