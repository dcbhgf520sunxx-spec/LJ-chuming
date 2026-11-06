import { ref as d } from "vue";
import { resolveComponent as R } from "vue";
import { openBlock as p } from "vue";
import { createBlock as _ } from "vue";
import { withCtx as o } from "vue";
import { createVNode as i } from "vue";
import { unref as t } from "vue";
import { withModifiers as M } from "vue";
import { createTextVNode as w } from "vue";
import { createCommentVNode as V } from "vue";
import { isRef as P } from "vue";
import { ElMessageBox as U } from "element-plus";
import { ElMessage as z } from "element-plus";
import { ElDatePicker as G } from "element-plus";
import { ElFormItem as j } from "element-plus";
import { ElForm as S } from "element-plus";
import { u as q, dA as g, G as E, L as H, R as $, S as J } from "../../../../../shared/runtime.js";
import { u as K, m as Q, n as W } from "../../../../../modules/use-form-config-data-098a0552.js";
import X from "../../../components/information-description/index.vue.js";
import "../../../../../modules/project-information-053c195b.js";
const oe = { __name: "detail", props: { modelValue: { type: Boolean, default: void 0 }, currentRow: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} } }, emits: ["update:modelValue", "success"], setup(c, { emit: I }) {
  const r = c, D = I, { visible: m, handleClose: y } = q({ emit: D, props: r, showHook: k }), u = d(false), C = d(), s = d({ caDate: void 0 }), b = { caDate: [{ required: true, message: "请选择CA锁有效期截止日", trigger: "change" }] }, { fetchFormItemList: O, fetchFormDetail: h, formItemList: v, serchFormDetail: l } = K();
  function k() {
    F(), x();
  }
  async function F() {
    var a;
    try {
      await h({ pageEnum: g.SUPPLIER_INTO_RECORD_CONFIG.V, params: r.currentRow }), s.value.caDate = (a = l.value) == null ? void 0 : a.caLockDate, console.log(l.value, "serchFormDetail");
    } catch (e) {
      console.log(e);
    }
  }
  async function x() {
    try {
      console.log(g.FIRM_RECORD_CONFIG.V), await O({ pageEnum: g.SUPPLIER_INTO_RECORD_CONFIG.V }), console.log(v.value);
    } catch (a) {
      console.log(a);
    }
  }
  async function L() {
    C.value.validate(async (a) => {
      var e;
      if (a) try {
        u.value = true, await U.confirm("是否确认设置CA锁的有效期限？", "提示", { closeOnClickModal: false, confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }), await W({ id: (e = r.currentRow) == null ? void 0 : e.id, caDate: s.value.caDate }), z.success("CA锁的有效期限设置成功"), y(), D("success");
      } catch (f) {
        console.log(f, "CA锁的有效期限设置失败");
      } finally {
        u.value = false;
      }
    });
  }
  return (a, e) => {
    const f = G, A = j, T = S, N = R("common-button"), B = R("common-drawer");
    return p(), _(B, { modelValue: t(m), "onUpdate:modelValue": e[2] || (e[2] = (n) => P(m) ? m.value = n : null), "close-on-click-modal": false, "before-close": t(y), size: "100%", title: "供应商详情" }, { titleAfter: o(() => [i(T, { ref_key: "formRef", ref: C, "label-position": "left", model: s.value, rules: b, style: { "margin-top": "20px" } }, { default: o(() => [i(A, { label: "CA锁有效期截止日：", prop: "caDate" }, { default: o(() => [i(f, { modelValue: s.value.caDate, "onUpdate:modelValue": e[0] || (e[0] = (n) => s.value.caDate = n), "value-format": "x", style: { "margin-right": "10px" }, placeholder: "请选择CA锁有效期截止日" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model"]), t(E)(c.permission.save) ? (p(), _(N, { key: 0, size: "default", type: "success", loading: u.value, onClick: M(L, ["stop"]) }, { default: o(() => e[3] || (e[3] = [w("保存")])), _: 1, __: [3] }, 8, ["loading"])) : V("", true)]), titleRight: o(() => [t(E)(c.permission.export) ? (p(), _(H, { key: 0, fn: t(Q), params: { id: r.currentRow.id }, size: "default" }, { default: o(() => e[4] || (e[4] = [w(" 下载 ")])), _: 1, __: [4] }, 8, ["fn", "params"])) : V("", true)]), content: o(() => [i(t(X), { "descriptions-list": t(v), "form-detail": t(l), style: { "margin-bottom": "10px" } }, null, 8, ["descriptions-list", "form-detail"]), i($, { showView: "", "show-download": "", files: t(l).attachmentDTOList, "onUpdate:files": e[1] || (e[1] = (n) => t(l).attachmentDTOList = n), "file-classify": t(J).RECORD_ATT.V, disabled: true, delDisabled: true }, null, 8, ["files", "file-classify"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  oe as default
};
