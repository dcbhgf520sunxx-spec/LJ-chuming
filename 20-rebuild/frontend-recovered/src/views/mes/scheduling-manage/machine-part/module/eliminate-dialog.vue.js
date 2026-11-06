import { ref as f } from "vue";
import { resolveComponent as b } from "vue";
import { openBlock as _ } from "vue";
import { createBlock as v } from "vue";
import { withCtx as n } from "vue";
import { createVNode as t } from "vue";
import { createTextVNode as g } from "vue";
import { unref as r } from "vue";
import { withDirectives as S } from "vue";
import { isRef as E } from "vue";
import { ElNotification as j } from "element-plus";
import { ElButton as I } from "element-plus";
import { ElTableColumn as M } from "element-plus";
import { vLoading as O } from "element-plus";
import { u as R, o as T, q$ as U, ba as $ } from "../../../../../shared/runtime.js";
const G = { __name: "eliminate-dialog", props: { visible: { type: Boolean, default: false }, info: { type: Object, default: () => ({}) }, eliminateList: { type: Array, default: () => [] } }, emits: ["update:visible", "close", "success", "handleDel", "handleBatchDel"], setup(d, { emit: k }) {
  const o = k, u = d, { visible: i, handleClose: m } = R({ emit: o, props: u, field: "visible", showHook: x, closeHook: () => {
    o("close");
  } }), { maxHeight: w } = T({ wrapperBox: [".el-dialog__body"], minHeight: 300, navbar: false }, i), C = f(false), p = f([]), s = f(false);
  async function x() {
    console.log("props.eliminateList:", u.eliminateList);
  }
  function L(a) {
    p.value = a;
  }
  function D(a, e) {
    o("handleDel", { row: a, id: e, type: 2 });
  }
  const q = () => {
    o("handleBatchDel", { list: p.value, type: 2 });
  };
  async function B() {
    const a = u.eliminateList.map((e) => ({ needId: e.id, quantity: e.quantity, serialNumber: e.serialNumber }));
    s.value = true;
    try {
      await U(a), j({ title: "作废成功", type: "success", duration: 2e3 }), o("update:visible", false), m(), o("success");
    } catch (e) {
      console.error(e);
    } finally {
      s.value = false;
    }
  }
  const N = (a) => $(a, { props: ["quantity"] });
  return (a, e) => {
    const y = I, h = b("common-button"), l = M, V = b("common-table"), z = b("common-drawer"), H = O;
    return _(), v(z, { title: "剔除数据汇总", modelValue: r(i), "onUpdate:modelValue": e[0] || (e[0] = (c) => E(i) ? i.value = c : null), "show-close": false, "before-close": r(m), size: "50%", closeOnClickModal: false }, { titleRight: n(() => [t(y, { type: "primary", size: "default", onClick: B, disabled: !d.eliminateList.length, loading: s.value }, { default: n(() => e[1] || (e[1] = [g("确认")])), _: 1, __: [1] }, 8, ["disabled", "loading"]), t(y, { size: "default", type: "info", onClick: r(m), loading: s.value }, { default: n(() => e[2] || (e[2] = [g("取消")])), _: 1, __: [2] }, 8, ["onClick", "loading"])]), content: n(() => [t(h, { type: "danger", icon: "el-icon-delete", size: "default", disabled: !p.value.length, style: { float: "right", "margin-bottom": "10px" }, onClick: q }, { default: n(() => e[3] || (e[3] = [g(" 批量删除 ")])), _: 1, __: [3] }, 8, ["disabled"]), S((_(), v(V, { "return-source-data": "", data: d.eliminateList, "show-summary": "", "summary-method": N, "max-height": r(w), style: { width: "100%" }, onSelectionChange: L }, { default: n(() => [t(l, { type: "selection", width: "55", align: "center" }), t(l, { label: "序号", type: "index", align: "center", width: "60" }), t(l, { key: "serialNumber", prop: "serialNumber", "show-overflow-tooltip": true, label: "零件编号", "min-width": "120", align: "center" }), t(l, { key: "specification", prop: "specification", label: "规格", align: "center" }), t(l, { key: "length", prop: "length", label: "长度", align: "center" }), t(l, { key: "material", prop: "material", label: "材质", align: "center" }), t(l, { key: "quantity", prop: "quantity", label: "数量", align: "center" }), t(l, { label: "操作", width: "80", align: "center" }, { default: n(({ row: c }) => [t(h, { type: "danger", icon: "el-icon-delete", size: "default", onClick: (A) => D(c, c.id) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[H, C.value]])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  G as default
};
