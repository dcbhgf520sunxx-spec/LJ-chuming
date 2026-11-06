import { computed as R } from "vue";
import { ref as i } from "vue";
import { watch as I } from "vue";
import { resolveComponent as b } from "vue";
import { openBlock as T } from "vue";
import { createBlock as w } from "vue";
import { withCtx as a } from "vue";
import { createElementVNode as p } from "vue";
import { createVNode as t } from "vue";
import { createTextVNode as f } from "vue";
import { createCommentVNode as h } from "vue";
import { ElAlert as q } from "element-plus";
import { ElRadio as z } from "element-plus";
import { ElRadioGroup as F } from "element-plus";
import { ElFormItem as U } from "element-plus";
import { ElForm as L } from "element-plus";
import { ElDialog as S } from "element-plus";
import { _ as G, nP as J } from "../../../../../shared/runtime.js";
const M = { class: "dialog-footer" }, P = { __name: "select-all-dialog", props: { modelValue: { type: Boolean, default: false }, projectId: { type: [Number, String], default: void 0 } }, emits: ["update:modelValue", "confirm"], setup(x, { emit: k }) {
  const n = x, _ = k, r = R({ get: () => n.modelValue, set: (o) => {
    o && (l.value.rangeType = 2, l.value.monomerId = void 0), _("update:modelValue", o);
  } }), u = i(), c = i(false), s = i([]), l = i({ rangeType: 2, monomerId: void 0 }), C = { rangeType: [{ required: true, message: "请选择范围类型", trigger: "change" }], monomerId: [{ validator: (o, e, m) => {
    l.value.rangeType === 4 && !e ? m(new Error("请选择单体")) : m();
  }, trigger: "change" }] };
  async function v() {
    if (!n.projectId) {
      s.value = [];
      return;
    }
    try {
      const o = await J(n.projectId);
      s.value = ((o == null ? void 0 : o.content) || []).map((e) => ({ id: e.id, name: e.name }));
    } catch (o) {
      console.log("获取单体列表失败", o), s.value = [];
    }
  }
  async function E() {
    if (u.value) try {
      await u.value.validate(), c.value = true;
      try {
        _("confirm", l.value.rangeType, l.value.monomerId), r.value = false;
      } catch {
      } finally {
        c.value = false;
      }
    } catch (o) {
      console.log("表单验证失败", o);
    }
  }
  function j() {
    var o;
    r.value = false, l.value.rangeType = 2, l.value.monomerId = void 0, (o = u.value) == null || o.resetFields();
  }
  return I(() => n.projectId, (o) => {
    o && v();
  }, { immediate: true }), I(() => r.value, (o) => {
    o && n.projectId && (v(), l.value.rangeType = 2, l.value.monomerId = void 0);
  }), (o, e) => {
    const m = q, g = z, B = F, y = U, N = b("common-select"), A = L, V = b("common-button"), D = S;
    return T(), w(D, { modelValue: r.value, "onUpdate:modelValue": e[2] || (e[2] = (d) => r.value = d), title: "全选选择", width: "500px", "close-on-click-modal": false, "close-on-press-escape": false }, { footer: a(() => [p("div", M, [t(V, { size: "default", onClick: j }, { default: a(() => e[6] || (e[6] = [f("取消")])), _: 1, __: [6] }), t(V, { type: "primary", size: "default", loading: c.value, onClick: E }, { default: a(() => e[7] || (e[7] = [f("保存")])), _: 1, __: [7] }, 8, ["loading"])])]), default: a(() => [t(m, { closable: false, type: "info", "show-icon": "", style: { "margin-bottom": "20px" } }, { default: a(() => e[3] || (e[3] = [p("div", { style: { "line-height": "1.8" } }, [p("div", null, "1、可分别选择一个项目，还是一个单体，如果选择单体，单体为必须输入项"), p("div", null, '2、选择并保存后，直接转到"创建工艺"页面')], -1)])), _: 1 }), t(A, { ref_key: "formRef", ref: u, model: l.value, rules: C, "label-width": "100px" }, { default: a(() => [t(y, { label: "请选择:", prop: "rangeType", required: "" }, { default: a(() => [t(B, { modelValue: l.value.rangeType, "onUpdate:modelValue": e[0] || (e[0] = (d) => l.value.rangeType = d) }, { default: a(() => [t(g, { label: 2 }, { default: a(() => e[4] || (e[4] = [f("整个项目")])), _: 1, __: [4] }), t(g, { label: 4 }, { default: a(() => e[5] || (e[5] = [f("一个单体")])), _: 1, __: [5] })]), _: 1 }, 8, ["modelValue"])]), _: 1 }), l.value.rangeType === 4 ? (T(), w(y, { key: 0, label: "请选择:", prop: "monomerId", required: "" }, { default: a(() => [t(N, { modelValue: l.value.monomerId, "onUpdate:modelValue": e[1] || (e[1] = (d) => l.value.monomerId = d), options: s.value, dataStructure: { key: "id", label: "name", value: "id" }, clearable: "", placeholder: "选择单体", style: { width: "100%" } }, null, 8, ["modelValue", "options"])]), _: 1 })) : h("", true)]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["modelValue"]);
  };
} }, Q = G(P, [["__scopeId", "data-v-f091d3d0"]]);
export {
  Q as default
};
