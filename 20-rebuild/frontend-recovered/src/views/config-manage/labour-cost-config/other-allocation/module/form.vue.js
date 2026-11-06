import { ref as p } from "vue";
import { computed as y } from "vue";
import { onMounted as C } from "vue";
import { resolveComponent as g } from "vue";
import { openBlock as z } from "vue";
import { createBlock as M } from "vue";
import { withCtx as a } from "vue";
import { createVNode as o } from "vue";
import { unref as e } from "vue";
import { createTextVNode as q } from "vue";
import { ElInput as E } from "element-plus";
import { ElFormItem as Q } from "element-plus";
import { ElCascader as j } from "element-plus";
import { ElForm as B } from "element-plus";
import { l as i, ao as P, er as R } from "../../../../../shared/runtime.js";
function S(l) {
  return i({ module: "system", url: "system/other-apportionment/list", method: "get", params: l });
}
function T(l) {
  return i({ module: "system", url: "system/other-apportionment", method: "post", data: l });
}
function A(l) {
  return i({ module: "system", url: "system/other-apportionment", method: "put", data: l });
}
function D(l) {
  return i({ module: "system", url: `system/other-apportionment/${l}`, method: "delete" });
}
function H(l) {
  return i({ url: "/api/system/other-apportionment/status", method: "put", params: l });
}
function N() {
  return i({ url: "/api/mes/building/process/artifact-process-list", method: "get" });
}
function O() {
  return i({ url: "/api/mes/building/factory/enable-factory-list-select", method: "get" });
}
const J = { get: S, add: T, edit: A, del: D }, W = { __name: "form", setup(l) {
  const c = p(), h = p(), _ = p(), b = { id: void 0, processId: void 0, leaderId: void 0, organizationType: void 0, factoryId: void 0, unit: "吨" }, { crud: u, form: r } = P(b, c);
  y(() => u.status.edit >= 1);
  const f = p([]), w = { type: [{ required: true, message: "请输入类型", trigger: "blur" }], factoryId: [{ required: true, message: "请选择工厂", trigger: "change" }], price: [{ required: true, message: "请输入单价", trigger: "blur" }], inventoryQuantity: [{ required: true, message: "请输入库量", trigger: "blur" }], workshopId: [{ required: true, message: "请选择车间", trigger: "change" }] }, V = y(() => ({ value: "id", label: "name", children: "children", emitPath: false }));
  async function v() {
    try {
      h.value = await N();
    } catch (n) {
      console.log(n);
    }
  }
  async function x() {
    try {
      _.value = await O();
    } catch (n) {
      console.log(n);
    }
  }
  C(() => k());
  async function k() {
    try {
      const { content: n } = await R({});
      n.forEach((t) => {
        t.children = t.workshopList;
      }), console.log(n), f.value = n;
    } catch {
      console.log("请求工厂-车间-生产线的层级接口失败");
    }
  }
  return v(), x(), (n, t) => {
    const I = g("common-button"), m = E, d = Q, L = j, F = B, U = g("common-dialog");
    return z(), M(U, { "append-to-body": "", "close-on-click-modal": false, "before-close": e(u).cancelCU, visible: e(u).status.cu > 0, title: e(u).status.title, width: "550px" }, { titleRight: a(() => [o(I, { loading: e(u).status.cu === 2, type: "primary", size: "default", onClick: e(u).submitCU }, { default: a(() => t[5] || (t[5] = [q("确认")])), _: 1, __: [5] }, 8, ["loading", "onClick"])]), default: a(() => [o(F, { ref_key: "formRef", ref: c, model: e(r), rules: w, size: "default", "label-width": "100px" }, { default: a(() => [o(d, { label: "类型", prop: "type" }, { default: a(() => [o(m, { modelValue: e(r).type, "onUpdate:modelValue": t[0] || (t[0] = (s) => e(r).type = s), modelModifiers: { trim: true }, maxlength: "20", type: "text", placeholder: "输入类型", style: { width: "270px" } }, null, 8, ["modelValue"])]), _: 1 }), o(d, { label: "车间", prop: "workshopId" }, { default: a(() => [o(L, { options: f.value, modelValue: e(r).workshopId, "onUpdate:modelValue": t[1] || (t[1] = (s) => e(r).workshopId = s), props: V.value, separator: " > ", "show-all-levels": "", clearable: "", size: "default", class: "filter-item", style: { width: "270px" }, placeholder: "全部车间" }, null, 8, ["options", "modelValue", "props"])]), _: 1 }), o(d, { label: "入库量", prop: "inventoryQuantity" }, { default: a(() => [o(m, { modelValue: e(r).inventoryQuantity, "onUpdate:modelValue": t[2] || (t[2] = (s) => e(r).inventoryQuantity = s), modelModifiers: { trim: true }, type: "text", placeholder: "请输入入库量", style: { width: "270px" } }, null, 8, ["modelValue"])]), _: 1 }), o(d, { label: "计算单位", prop: "unit" }, { default: a(() => [o(m, { disabled: "", modelValue: e(r).unit, "onUpdate:modelValue": t[3] || (t[3] = (s) => e(r).unit = s), modelModifiers: { trim: true }, type: "text", placeholder: "请输入计算单位", style: { width: "270px" } }, null, 8, ["modelValue"])]), _: 1 }), o(d, { label: "单价（元）", prop: "price" }, { default: a(() => [o(m, { modelValue: e(r).price, "onUpdate:modelValue": t[4] || (t[4] = (s) => e(r).price = s), modelModifiers: { number: true }, type: "number", placeholder: "请输入单价", style: { width: "270px" } }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} }, K = Object.freeze(Object.defineProperty({ __proto__: null, default: W }, Symbol.toStringTag, { value: "Module" }));
export {
  W as _,
  J as c,
  H as e,
  K as f
};
