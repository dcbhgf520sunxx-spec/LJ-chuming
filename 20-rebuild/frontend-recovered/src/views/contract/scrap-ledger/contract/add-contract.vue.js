import { ref as U } from "vue";
import { resolveComponent as i } from "vue";
import { openBlock as R } from "vue";
import { createBlock as B } from "vue";
import { withCtx as o } from "vue";
import { createVNode as l } from "vue";
import { createTextVNode as D } from "vue";
import { unref as d } from "vue";
import { isRef as E } from "vue";
import { ElTableColumn as T } from "element-plus";
import { ElInput as q } from "element-plus";
import { a as z } from "../../../../modules/scrap-ledger-452ee452.js";
import { u as I, aw as L } from "../../../../shared/runtime.js";
const M = { __name: "add-contract", props: { modelValue: { type: Boolean, default: false } }, emits: ["update:modelValue", "success"], setup(b, { emit: _ }) {
  const h = b, m = _, { visible: c, handleClose: p } = I({ props: h, emit: m, showHook: V }), t = U([{ purchaser: void 0, serialNumber: void 0 }]);
  function V() {
    t.value = [{ purchaser: void 0, serialNumber: void 0 }];
  }
  const g = { serialNumber: [{ required: true, message: "请输入合同编号", trigger: "blur" }], purchaser: [{ required: true, message: "请输入购买方", trigger: "blur" }] }, { tableValidate: C, wrongCellMask: v } = L({ rules: g });
  async function y() {
    const { validResult: s, dealList: n } = C(t.value);
    if (s) t.value = n;
    else return s;
    const u = [];
    t.value.forEach((e) => {
      e.purchaser && e.serialNumber && u.push(e);
    });
    try {
      await z(u), p(), m("success");
    } catch (e) {
      console.log(e, "合同配置列表新增失败");
    }
  }
  function N() {
    t.value.push({ purchaser: void 0, serialNumber: void 0 });
  }
  function k(s) {
    t.value.splice(s, 1);
  }
  return (s, n) => {
    const u = i("common-button"), e = T, f = q, w = i("common-table"), x = i("common-dialog");
    return R(), B(x, { modelValue: d(c), "onUpdate:modelValue": n[0] || (n[0] = (a) => E(c) ? c.value = a : null), "before-close": d(p), title: "新增合同", width: "55%" }, { titleRight: o(() => [l(u, { type: "success", icon: "el-icon-plus", size: "default", onClick: N }), l(u, { type: "primary", size: "default", onClick: y }, { default: o(() => n[1] || (n[1] = [D("确认")])), _: 1, __: [1] })]), default: o(() => [l(w, { data: t.value, returnSourceData: "", "cell-class-name": d(v) }, { default: o(() => [l(e, { label: "序号", align: "center", width: "100", type: "index" }), l(e, { label: "合同编号", key: "serialNumber", prop: "serialNumber", align: "center" }, { default: o(({ row: a }) => [l(f, { modelValue: a.serialNumber, "onUpdate:modelValue": (r) => a.serialNumber = r }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), l(e, { label: "购买方", key: "purchaser", prop: "purchaser", align: "center" }, { default: o(({ row: a }) => [l(f, { modelValue: a.purchaser, "onUpdate:modelValue": (r) => a.purchaser = r }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), l(e, { label: "操作", align: "center", width: "150" }, { default: o(({ $index: a }) => [l(u, { icon: "el-icon-delete", type: "danger", onClick: (r) => k(a) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "cell-class-name"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  M as default
};
