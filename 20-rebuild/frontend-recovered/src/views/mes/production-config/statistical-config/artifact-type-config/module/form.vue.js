import { ref as m } from "vue";
import { resolveComponent as k } from "vue";
import { openBlock as i } from "vue";
import { createBlock as d } from "vue";
import { withCtx as o } from "vue";
import { createVNode as u } from "vue";
import { unref as t } from "vue";
import { createTextVNode as f } from "vue";
import { createElementBlock as B } from "vue";
import { Fragment as E } from "vue";
import { renderList as F } from "vue";
import { toDisplayString as R } from "vue";
import { withKeys as I } from "vue";
import { nextTick as U } from "vue";
import { ElInput as T } from "element-plus";
import { ElFormItem as q } from "element-plus";
import { ElTag as K } from "element-plus";
import { ElForm as S } from "element-plus";
import { ao as $ } from "../../../../../../shared/runtime.js";
const M = { __name: "form", setup(j) {
  const c = m(), N = { id: void 0, typeName: void 0, inventoryNames: [] }, l = m(""), p = m(false), _ = m(), { crud: s, form: n } = $(N, c), x = { typeName: [{ required: true, message: "请填写种类", trigger: "blur" }], inventoryNames: [{ required: true, message: "请填写包含构件编号", trigger: "blur" }] }, C = (r) => {
    n.inventoryNames.splice(n.inventoryNames.indexOf(r), 1);
  }, V = () => {
    p.value = true, U(() => {
      var r, e;
      (e = (r = _.value) == null ? void 0 : r.input) == null || e.focus();
    });
  }, y = () => {
    if (/^[A-Z]+$/.test(l.value)) l.value && n.inventoryNames.push(l.value);
    else {
      l.value = "";
      return;
    }
    p.value = false, l.value = "";
  };
  return (r, e) => {
    const v = k("common-button"), g = T, b = q, h = K, w = S, z = k("common-dialog");
    return i(), d(z, { "append-to-body": "", "close-on-click-modal": false, "before-close": t(s).cancelCU, visible: t(s).status.cu > 0, title: t(s).status.title, width: "500px" }, { titleRight: o(() => [u(v, { loading: t(s).status.cu === 2, type: "primary", size: "default", onClick: t(s).submitCU }, { default: o(() => e[2] || (e[2] = [f("确认")])), _: 1, __: [2] }, 8, ["loading", "onClick"])]), default: o(() => [u(w, { ref_key: "formRef", ref: c, model: t(n), rules: x, size: "default", "label-width": "110px" }, { default: o(() => [u(b, { label: "种类", prop: "typeName" }, { default: o(() => [u(g, { modelValue: t(n).typeName, "onUpdate:modelValue": e[0] || (e[0] = (a) => t(n).typeName = a), modelModifiers: { trim: true }, type: "text", placeholder: "请填写种类", style: { width: "270px" } }, null, 8, ["modelValue"])]), _: 1 }), u(b, { label: "包含构件编号", prop: "inventoryNames" }, { default: o(() => [(i(true), B(E, null, F(t(n).inventoryNames, (a) => (i(), d(h, { key: a, style: { "margin-right": "3px", "margin-bottom": "3px" }, closable: "", "disable-transitions": false, size: "large", effect: "plain", onClose: (A) => C(a) }, { default: o(() => [f(R(a), 1)]), _: 2 }, 1032, ["onClose"]))), 128)), p.value ? (i(), d(g, { key: 0, ref_key: "inputRef", ref: _, modelValue: l.value, "onUpdate:modelValue": e[1] || (e[1] = (a) => l.value = a), size: "default", placeholder: "大写字母", style: { width: "120px" }, onKeyup: I(y, ["enter"]), onBlur: y }, null, 8, ["modelValue"])) : (i(), d(v, { key: 1, size: "default", onClick: V }, { default: o(() => e[3] || (e[3] = [f(" + 新增 ")])), _: 1, __: [3] }))]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} };
export {
  M as default
};
