import { ref as n } from "vue";
import { reactive as B } from "vue";
import { resolveComponent as w } from "vue";
import { openBlock as H } from "vue";
import { createElementBlock as U } from "vue";
import { createVNode as o } from "vue";
import { withCtx as a } from "vue";
import { createTextVNode as j } from "vue";
import { createElementVNode as V } from "vue";
import { toDisplayString as C } from "vue";
import { unref as E } from "vue";
import { isRef as z } from "vue";
import { Fragment as G } from "vue";
import { ElMessage as P } from "element-plus";
import { ElNotification as S } from "element-plus";
import { ElFormItem as A } from "element-plus";
import { ElCascader as M } from "element-plus";
import { ElForm as W } from "element-plus";
import { a as $ } from "../../../../../../modules/common-a5dc7899.js";
import { u as O, a3 as J, qT as K } from "../../../../../../shared/runtime.js";
import { m as Q } from "../../../../../../modules/use-scheduling-groups-e49a6ba2.js";
import X from "./drill-scheduling-dialog.vue.js";
import "../../../../../../modules/artifact-f1b0ca44.js";
const le = { __name: "part-dialog", props: { visible: { type: Boolean, default: false }, partList: { type: Object, default: () => {
} } }, emits: ["update:visible", "success"], setup(m, { emit: T }) {
  const I = n(), N = n(), f = n(false), h = n({}), s = m, g = T, { visible: b, handleClose: y } = O({ emit: g, props: s, field: "visible", showHook: x });
  function R() {
    g("success");
  }
  const l = B({ groupsId: void 0 });
  function x() {
    l.groupsId = void 0, D();
  }
  const q = { groupsId: [{ required: true, message: "请选择生产班组", trigger: "change" }] }, k = n(false), L = n({ list: [], obj: {} });
  async function D() {
    if (!k.value) try {
      L.value = await Q({ productType: J.MACHINE_PART.V }), k.value = true;
    } catch (v) {
      console.log("获取生产组的信息失败", v);
    }
  }
  async function F(v) {
    var i, d, p, c, u, t;
    [].push({ id: (i = s.partList) == null ? void 0 : i.id, quantity: (d = s.partList) == null ? void 0 : d.quantity });
    const _ = { groupsId: l.groupsId, schedulingId: (p = s.partList) == null ? void 0 : p.id };
    if (!l.groupsId) {
      P.error("请选择生产组");
      return;
    }
    try {
      const r = await K({ thick: (c = s.partList) == null ? void 0 : c.thick, cutConfigId: (u = s.partList) == null ? void 0 : u.cutConfigId, schedulingId: (t = s.partList) == null ? void 0 : t.id });
      r != null && r.boolDrillEnum ? (f.value = true, h.value = r || {}) : await $(_), S({ title: "零件下发保存成功", type: "success", duration: 2500 }), y(), g("success");
    } catch (r) {
      console.log("零件下发保存失败", r);
    }
  }
  return (v, e) => {
    var u;
    const _ = w("common-button"), i = A, d = M, p = W, c = w("common-dialog");
    return H(), U(G, null, [o(c, { ref_key: "dialogRef", ref: N, title: "零件排产", visible: E(b), "onUpdate:visible": e[2] || (e[2] = (t) => z(b) ? b.value = t : null), "before-close": E(y), width: "400px" }, { titleRight: a(() => [o(_, { type: "primary", size: "default", onClick: e[0] || (e[0] = (t) => F(I.value)) }, { default: a(() => e[4] || (e[4] = [j(" 确定 ")])), _: 1, __: [4] })]), default: a(() => [o(p, { ref_key: "formRef", ref: I, model: l, rules: q, size: "default", "label-width": "120px", class: "demo-form" }, { default: a(() => [o(i, { label: "零件数:", prop: "quantity" }, { default: a(() => [V("span", null, C(m.partList.quantity), 1)]), _: 1 }), o(i, { label: "零件量:", prop: "totalNetWeight" }, { default: a(() => [V("span", null, C(m.partList.totalNetWeight), 1)]), _: 1 }), o(i, { label: "生产组:", prop: "groupsId" }, { default: a(() => [o(d, { modelValue: l.groupsId, "onUpdate:modelValue": e[1] || (e[1] = (t) => l.groupsId = t), options: L.value.list, props: { value: "id", label: "name", children: "children", expandTrigger: "hover", emitPath: false }, "show-all-levels": false, style: { width: "100%" }, filterable: "", clearable: "", placeholder: "请选择生产组" }, null, 8, ["modelValue", "options"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["visible", "before-close"]), o(X, { visible: f.value, "onUpdate:visible": e[3] || (e[3] = (t) => f.value = t), "drill-data": h.value, groupsId: l.groupsId, onSuccess: R, schedulingId: (u = s.partList) == null ? void 0 : u.id }, null, 8, ["visible", "drill-data", "groupsId", "schedulingId"])], 64);
  };
} };
export {
  le as default
};
