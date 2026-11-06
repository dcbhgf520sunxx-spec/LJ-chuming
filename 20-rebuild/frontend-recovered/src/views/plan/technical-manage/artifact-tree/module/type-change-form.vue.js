import { ref as r } from "vue";
import { watch as z } from "vue";
import { resolveComponent as u } from "vue";
import { openBlock as m } from "vue";
import { createBlock as i } from "vue";
import { withCtx as o } from "vue";
import { createVNode as l } from "vue";
import { createTextVNode as T } from "vue";
import { unref as b } from "vue";
import { createCommentVNode as g } from "vue";
import { toDisplayString as R } from "vue";
import { isRef as U } from "vue";
import { ElMessage as I } from "element-plus";
import { ElFormItem as O } from "element-plus";
import { ElInput as D } from "element-plus";
import { ElForm as j } from "element-plus";
import { o as q } from "../../../../../modules/artifact-tree-bcd3b733.js";
import { _ as J, tx as x, u as M } from "../../../../../shared/runtime.js";
const L = { __name: "type-change-form", props: { modelValue: { type: Boolean, require: true }, currentArea: { type: Object, default: () => {
} } }, emits: ["success", "update:modelValue", "editAreaBatchSucccess"], setup(V, { emit: k }) {
  const h = r(), e = r(JSON.parse(JSON.stringify({ alterationType: 1, type: void 0 }))), d = r(false), c = V, A = r([{ id: 1, name: "二次利用变更" }, { id: 2, name: "清单导入变更" }, { id: 3, name: "批次名称变更" }]);
  z(() => c.modelValue, (y) => {
    y && (e.value.type = x.AREA.V);
  }, { deep: true, immediate: true });
  const p = k, { visible: f, handleClose: _ } = M({ emit: p, props: c });
  function C() {
    p("success", e.value.type, e.value.alterationType), _();
  }
  const w = { name: [{ required: true, message: "请输入名称", trigger: "blur" }] };
  async function F(y) {
    var t;
    if (e.value.alterationType === 3) {
      d.value = true;
      try {
        if (!await h.value.validate()) return;
        const v = { id: (t = c.currentArea) == null ? void 0 : t.id, name: e.value.name };
        await q(v), p("editAreaBatchSucccess"), I.success("批次名称变更成功"), _();
      } catch (n) {
        console.log(n);
      } finally {
        d.value = false;
      }
    } else C();
  }
  return (y, t) => {
    const n = u("common-button"), v = u("common-radio-button"), s = O, S = u("common-radio"), B = D, E = j, N = u("common-dialog");
    return m(), i(N, { "append-to-body": "", "close-on-click-modal": false, "before-close": b(_), modelValue: b(f), "onUpdate:modelValue": t[3] || (t[3] = (a) => U(f) ? f.value = a : null), title: "变更操作", width: "650px" }, { titleRight: o(() => [l(n, { type: "primary", size: "default", onClick: F, loading: d.value }, { default: o(() => t[4] || (t[4] = [T("确认")])), _: 1, __: [4] }, 8, ["loading"])]), default: o(() => [l(E, { ref_key: "formRef", ref: h, model: e.value, size: "default", rules: w, "label-width": "130px" }, { default: o(() => [l(s, { label: "变更类型：", prop: "changeType" }, { default: o(() => [l(v, { modelValue: e.value.alterationType, "onUpdate:modelValue": t[0] || (t[0] = (a) => e.value.alterationType = a), options: A.value, dataStructure: { key: "id", label: "name", value: "id" }, type: "other", size: "default", class: "filter-item" }, null, 8, ["modelValue", "options"])]), _: 1 }), e.value.alterationType === 1 ? (m(), i(s, { key: 0, label: "变更内容：", prop: "type" }, { default: o(() => [l(S, { modelValue: e.value.type, "onUpdate:modelValue": t[1] || (t[1] = (a) => e.value.type = a), options: b(x).ENUM, type: "enum", size: "default" }, null, 8, ["modelValue", "options"])]), _: 1 })) : g("", true), e.value.alterationType === 3 ? (m(), i(s, { key: 1, label: "原名称：", prop: "currentArea" }, { default: o(() => {
      var a;
      return [T(R((a = V.currentArea) == null ? void 0 : a.name), 1)];
    }), _: 1 })) : g("", true), e.value.alterationType === 3 ? (m(), i(s, { key: 2, label: "新名称：", prop: "name" }, { default: o(() => [l(B, { modelValue: e.value.name, "onUpdate:modelValue": t[2] || (t[2] = (a) => e.value.name = a), clearable: "", placeholder: "输入新名称", style: { width: "310px" } }, null, 8, ["modelValue"])]), _: 1 })) : g("", true)]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "modelValue"]);
  };
} }, Q = J(L, [["__scopeId", "data-v-7c33b785"]]);
export {
  Q as default
};
