import { ref as g } from "vue";
import { resolveComponent as P } from "vue";
import { openBlock as _ } from "vue";
import { createBlock as U } from "vue";
import { withCtx as c } from "vue";
import { createVNode as n } from "vue";
import { unref as r } from "vue";
import { createTextVNode as z } from "vue";
import { createElementVNode as b } from "vue";
import { createElementBlock as v } from "vue";
import { Fragment as I } from "vue";
import { renderList as O } from "vue";
import { withDirectives as L } from "vue";
import { vShow as N } from "vue";
import { ElMessage as y } from "element-plus";
import { ElInput as S } from "element-plus";
import { ElFormItem as R } from "element-plus";
import { ElInputNumber as q } from "element-plus";
import { ElForm as H } from "element-plus";
import { _ as K, ao as M } from "../../../../../../shared/runtime.js";
const T = { class: "process-container" }, A = { class: "process-box" }, D = { __name: "form", setup($) {
  const x = g(), i = g([]), h = { id: void 0, name: "", sort: void 0, list: [] }, { crud: p, form: t, CRUD: d } = M(h, x), w = { name: [{ required: true, message: "请填写类型名称", trigger: "blur" }, { min: 1, max: 30, message: "长度在 1 到 30 个字符", trigger: "blur" }], list: [{ required: true, message: "请填写规格前缀" }, { validator: (s, e, o) => {
    if (e && e.length) {
      for (const l in e) e[l].specPrefix ? o() : o(new Error("请填写规格前缀"));
      o();
    } else o(new Error("请填写规格前缀"));
  }, trigger: "change" }] };
  function V() {
    t.list.push({ specPrefix: void 0 });
  }
  function k(s) {
    t.list.splice(s, 1);
  }
  function C(s, e) {
    const o = i.value.find((l) => l.index === e);
    if (o) if (s.specPrefix) {
      if (o.specPrefix === s.specPrefix) return;
      i.value.findIndex((l) => l.specPrefix === s.specPrefix) > -1 ? (y({ message: "规格前缀已存在，请重新填写", type: "error" }), s.specPrefix = void 0, o.specPrefix = void 0) : o.specPrefix = s.specPrefix;
    } else o.specPrefix = void 0;
    else s.specPrefix && (i.value.findIndex((l) => l.specPrefix === s.specPrefix) > -1 && (y({ message: "规格前缀已存在，请重新填写", type: "error" }), t.list[e].specPrefix = void 0), i.value.push({ specPrefix: s.specPrefix, index: e }));
  }
  return d.HOOK.beforeSubmit = () => {
    t.elementSpecList = [], t.list.map((s) => {
      t.elementSpecList.push(s.specPrefix);
    });
  }, d.HOOK.beforeToAdd = () => {
    i.value = [];
  }, d.HOOK.beforeToEdit = () => {
    i.value = [], t.list.map((s, e) => {
      i.value.push({ specPrefix: s.specPrefix, index: e });
    });
  }, (s, e) => {
    const o = P("common-button"), l = S, u = R, E = q, B = H, F = P("common-drawer");
    return _(), U(F, { "append-to-body": "", "close-on-click-modal": false, "before-close": r(p).cancelCU, visible: r(p).status.cu > 0, title: r(p).status.title, "wrapper-closable": false, size: "650px" }, { titleRight: c(() => [n(o, { loading: r(p).status.cu === 2, type: "primary", size: "default", onClick: r(p).submitCU }, { default: c(() => e[2] || (e[2] = [z("确认")])), _: 1, __: [2] }, 8, ["loading", "onClick"])]), content: c(() => [n(B, { ref_key: "formRef", ref: x, model: r(t), rules: w, size: "default", "label-width": "140px", style: {} }, { default: c(() => [n(u, { label: "类型命名", prop: "name" }, { default: c(() => [n(l, { modelValue: r(t).name, "onUpdate:modelValue": e[0] || (e[0] = (a) => r(t).name = a), modelModifiers: { trim: true }, type: "text", placeholder: "类型命名", style: { width: "270px" }, maxlength: "30" }, null, 8, ["modelValue"])]), _: 1 }), n(u, { label: "排序", prop: "sort" }, { default: c(() => [n(E, { modelValue: r(t).sort, "onUpdate:modelValue": e[1] || (e[1] = (a) => r(t).sort = a), modelModifiers: { number: true }, min: 1, max: 999, step: 1, "controls-position": "right", style: { width: "270px" } }, null, 8, ["modelValue"])]), _: 1 }), n(u, { label: "规格前缀", prop: "list" }, { default: c(() => [b("div", T, [b("div", A, [(_(true), v(I, null, O(r(t).list, (a, f) => (_(), v("div", { key: f, class: "process-drawer" }, [n(l, { modelValue: a.specPrefix, "onUpdate:modelValue": (m) => a.specPrefix = m, type: "text", placeholder: "规格前缀", style: { width: "270px", "margin-right": "5px" }, onBlur: (m) => C(a, f) }, null, 8, ["modelValue", "onUpdate:modelValue", "onBlur"]), L(n(o, { icon: "el-icon-delete", size: "default", type: "danger", style: { "margin-left": "6px" }, onClick: (m) => k(f) }, null, 8, ["onClick"]), [[N, r(t).list && r(t).list.length > 1]])]))), 128))]), n(o, { icon: "el-icon-plus", size: "default", type: "success", style: { margin: "0 0 12px 6px" }, onClick: V })])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} }, Q = K(D, [["__scopeId", "data-v-14977eb4"]]);
export {
  Q as default
};
