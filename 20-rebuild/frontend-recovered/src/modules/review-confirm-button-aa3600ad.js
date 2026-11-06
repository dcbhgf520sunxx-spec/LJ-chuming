import { computed as f } from "vue";
import { resolveComponent as m } from "vue";
import { openBlock as _ } from "vue";
import { createElementBlock as g } from "vue";
import { createVNode as t } from "vue";
import { withCtx as o } from "vue";
import { createTextVNode as u } from "vue";
import { Fragment as y } from "vue";
import { ElPopconfirm as b } from "element-plus";
const L = { __name: "review-confirm-button", props: { passedFn: { type: Function, required: true }, returnedFn: { type: Function, required: true }, passedLoading: { type: Boolean, default: false }, returnedLoading: { type: Boolean, default: false } }, emits: ["update:passedLoading", "update:returnedLoading"], setup(s, { emit: c }) {
  const r = c, e = s, a = f(() => e.passedLoading || e.returnedLoading);
  function p() {
    r("update:passedLoading", true), typeof e.passedFn == "function" && e.passedFn();
  }
  function l() {
    r("update:returnedLoading", true), typeof e.returnedFn == "function" && e.returnedFn();
  }
  return (F, n) => {
    const i = m("common-button"), d = b;
    return _(), g(y, null, [t(d, { "cancel-button-text": "取消", "confirm-button-text": "确定", icon: "el-icon-info", "icon-color": "green", title: "确认通过？", onConfirm: p }, { reference: o(() => [t(i, { loading: a.value, icon: "el-icon-position", size: "default", type: "primary" }, { default: o(() => n[0] || (n[0] = [u(" 通 过 ")])), _: 1, __: [0] }, 8, ["loading"])]), _: 1 }), t(d, { "cancel-button-text": "取消", "confirm-button-text": "确定", icon: "el-icon-info", "icon-color": "red", title: "确认退回？", onConfirm: l }, { reference: o(() => [t(i, { loading: a.value, icon: "el-icon-document-delete", size: "default", type: "danger" }, { default: o(() => n[1] || (n[1] = [u(" 退 回 ")])), _: 1, __: [1] }, 8, ["loading"])]), _: 1 })], 64);
  };
} };
export {
  L as _
};
