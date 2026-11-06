import { ref as d } from "vue";
import { computed as j } from "vue";
import { watch as q } from "vue";
import { resolveComponent as m } from "vue";
import { openBlock as h } from "vue";
import { createBlock as w } from "vue";
import { withCtx as a } from "vue";
import { withDirectives as I } from "vue";
import { createTextVNode as J } from "vue";
import { createVNode as t } from "vue";
import { unref as c } from "vue";
import { isRef as O } from "vue";
import { ElMessage as P } from "element-plus";
import { ElTableColumn as A } from "element-plus";
import { ElInput as F } from "element-plus";
import { ElDatePicker as G } from "element-plus";
import { ElPopconfirm as K } from "element-plus";
import { vLoading as Q } from "element-plus";
import { d as W } from "../../../../../modules/catalog-list-6b93ea83.js";
import { _ as X, o as Y, u as Z, au as $, aw as ee } from "../../../../../shared/runtime.js";
const te = { __name: "serialNumber-table", props: { modelValue: { type: Boolean, default: false }, selections: { type: Array, default: () => [] } }, emits: ["success", "update:modelValue"], setup(y, { emit: V }) {
  const p = V, f = y, _ = d(), x = d(false), v = d(false), i = d([]), N = { contractNumber: [{ required: true, message: "请填写合同编号", trigger: "blur" }], signStatus: [{ required: true, message: "请选择签订情况", trigger: "change" }] }, { tableValidate: k, wrongCellMask: D } = ee({ rules: N }), S = j(() => "合同编号录入"), { maxHeight: U } = Y({ mainBox: ".catalog-serial-table", extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, minHeight: 300 }, _), { visible: u, handleClose: g } = Z({ emit: p, props: f, closeHook: C });
  q(u, (l) => {
    l && (i.value = JSON.parse(JSON.stringify(f.selections)));
  }, { immediate: true });
  function E(l) {
    i.value.splice(l, 1);
  }
  function C() {
  }
  async function R() {
    try {
      const { validResult: l } = k(i.value);
      if (!l) return;
      const r = i.value.map((o) => ({ id: o.id, contractNumber: o.contractNumber, transferDate: o.transferDate, signStatus: o.signStatus, signDate: o.signDate }));
      await W(r), P.success("提交成功"), p("success"), g();
    } catch (l) {
      console.log(l, "合同目录编号录入");
    }
  }
  return (l, r) => {
    const o = m("common-button"), n = A, H = F, b = G, z = m("common-select"), B = K, M = m("common-table"), T = m("common-drawer"), L = Q;
    return h(), w(T, { ref_key: "drawerRef", ref: _, modelValue: c(u), "onUpdate:modelValue": r[0] || (r[0] = (e) => O(u) ? u.value = e : null), "content-loading": x.value, "close-on-click-modal": false, "before-close": c(g), title: S.value, "show-close": true, size: "80%", "custom-class": "catalog-serial-table" }, { titleRight: a(() => [I((h(), w(o, { size: "default", type: "primary", onClick: R }, { default: a(() => r[1] || (r[1] = [J("提交")])), _: 1, __: [1] })), [[L, v.value]])]), content: a(() => [t(M, { data: i.value, "max-height": c(U), "cell-class-name": c(D), showEmptySymbol: false, "return-source-data": "" }, { default: a(() => [t(n, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), t(n, { key: "projectName", align: "left", label: "项目名称", prop: "projectName", "show-overflow-tooltip": "", "min-width": "150" }), t(n, { key: "signerName", align: "left", label: "签订人", prop: "signerName", "show-overflow-tooltip": "", width: "110" }), t(n, { key: "contractNumber", align: "left", label: "合同编号", prop: "contractNumber", "show-overflow-tooltip": "", "min-width": "120" }, { default: a(({ row: e }) => [t(H, { modelValue: e.contractNumber, "onUpdate:modelValue": (s) => e.contractNumber = s, modelModifiers: { trim: true }, type: "text", placeholder: "合同编号", class: "input-underline", maxlength: "60" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), t(n, { key: "transferDate", prop: "transferDate", label: "移交日期", align: "center", width: "220" }, { default: a(({ row: e }) => [t(b, { modelValue: e.transferDate, "onUpdate:modelValue": (s) => e.transferDate = s, type: "date", size: "default", "value-format": "x", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), t(n, { key: "signStatus", prop: "signStatus", label: "签订情况", align: "center", width: "150" }, { default: a(({ row: e }) => [t(z, { modelValue: e.signStatus, "onUpdate:modelValue": (s) => e.signStatus = s, options: c($).ENUM, type: "enum", size: "default", clearable: "", style: { width: "100%" }, placeholder: "请选择" }, null, 8, ["modelValue", "onUpdate:modelValue", "options"])]), _: 1 }), t(n, { key: "signDate", prop: "signDate", label: "签订时间", align: "center", width: "220" }, { default: a(({ row: e }) => [t(b, { modelValue: e.signDate, "onUpdate:modelValue": (s) => e.signDate = s, type: "date", size: "default", "value-format": "x", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), t(n, { align: "center", fixed: "right", label: "操作", width: "80px" }, { default: a(({ $index: e }) => [t(B, { "confirm-button-text": "确定", "cancel-button-text": "取消", "icon-color": "red", title: "确定删除吗?", onConfirm: (s) => E(e) }, { reference: a(() => [t(o, { icon: "el-icon-delete", size: "default", type: "danger", disabled: e === 0 }, null, 8, ["disabled"])]), _: 2 }, 1032, ["onConfirm"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "cell-class-name"])]), _: 1 }, 8, ["modelValue", "content-loading", "before-close", "title"]);
  };
} }, ne = X(te, [["__scopeId", "data-v-f75ca00f"]]);
export {
  ne as default
};
