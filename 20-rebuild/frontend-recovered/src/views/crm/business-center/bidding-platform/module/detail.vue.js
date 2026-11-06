import { ref as d } from "vue";
import { resolveComponent as p } from "vue";
import { openBlock as _ } from "vue";
import { createBlock as g } from "vue";
import { withCtx as o } from "vue";
import { createVNode as n } from "vue";
import { unref as t } from "vue";
import { withModifiers as B } from "vue";
import { createTextVNode as E } from "vue";
import { createCommentVNode as w } from "vue";
import { isRef as P } from "vue";
import { ElMessageBox as z } from "element-plus";
import { ElMessage as U } from "element-plus";
import { ElDatePicker as j } from "element-plus";
import { ElFormItem as S } from "element-plus";
import { ElForm as q } from "element-plus";
import { _ as H, u as $, dA as v, G as C, L as J, R as K, S as Q } from "../../../../../shared/runtime.js";
import { u as W, b as X, s as Y } from "../../../../../modules/use-form-config-data-098a0552.js";
import Z from "../../../components/information-description/index.vue.js";
import "../../../../../modules/project-information-053c195b.js";
const ee = { __name: "detail", props: { modelValue: { type: Boolean, default: void 0 }, currentRow: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} } }, emits: ["update:modelValue", "success"], setup(c, { emit: V }) {
  const m = c, D = V, { visible: u, handleClose: y } = $({ emit: D, props: m, showHook: x }), f = d(false), R = d(), a = d({ caDate: void 0, platformFees: void 0 }), A = { caDate: [{ required: true, message: "请选择CA锁有效期截止日", trigger: "change" }], platformFees: [{ required: true, message: "请填写平台年费", trigger: "change" }] }, { fetchFormItemList: T, fetchFormDetail: h, formItemList: b, serchFormDetail: i } = W();
  function x() {
    I(), O();
  }
  async function I() {
    var l, e;
    try {
      await h({ pageEnum: v.PLATFORM_REGISTRATION_RECORD_PAGE_MANAGEMENT.V, params: m.currentRow }), a.value.caDate = (l = i.value) == null ? void 0 : l.caLockDate, a.value.platformFees = (e = i.value) == null ? void 0 : e.platformFees, console.log(i.value, "serchFormDetail");
    } catch (r) {
      console.log(r);
    }
  }
  async function O() {
    try {
      console.log(v.FIRM_RECORD_CONFIG.V), await T({ pageEnum: v.PLATFORM_REGISTRATION_RECORD_PAGE_MANAGEMENT.V }), console.log(b.value);
    } catch (l) {
      console.log(l);
    }
  }
  async function k() {
    R.value.validate(async (l) => {
      var e;
      if (l) try {
        f.value = true, await z.confirm("是否确认设置CA锁的有效期限？", "提示", { closeOnClickModal: false, confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }), await Y({ id: (e = m.currentRow) == null ? void 0 : e.id, caDate: a.value.caDate, platformFees: a.value.platformFees }), U.success("CA锁的有效期限设置成功"), y(), D("success");
      } catch (r) {
        console.log(r, "CA锁的有效期限设置失败");
      } finally {
        f.value = false;
      }
    });
  }
  return (l, e) => {
    const r = j, F = S, M = p("common-input-number"), L = q, N = p("common-button"), G = p("common-drawer");
    return _(), g(G, { modelValue: t(u), "onUpdate:modelValue": e[3] || (e[3] = (s) => P(u) ? u.value = s : null), "close-on-click-modal": false, "before-close": t(y), size: "100%", title: "企业详情" }, { titleAfter: o(() => [n(L, { ref_key: "formRef", ref: R, "label-position": "left", model: a.value, rules: A, inline: "", style: { "margin-top": "20px" } }, { default: o(() => [n(F, { label: "CA锁有效期截止日：", prop: "caDate" }, { default: o(() => [n(r, { modelValue: a.value.caDate, "onUpdate:modelValue": e[0] || (e[0] = (s) => a.value.caDate = s), "value-format": "x", style: { "margin-right": "10px" }, placeholder: "请选择CA锁有效期截止日" }, null, 8, ["modelValue"])]), _: 1 }), n(F, { label: "平台年费：", prop: "platformFees" }, { default: o(() => [n(M, { modelValue: a.value.platformFees, "onUpdate:modelValue": e[1] || (e[1] = (s) => a.value.platformFees = s), step: 0.01, min: 0.01, precision: 2, controls: false, clearable: "", placeholder: "请填写平台年费", style: { width: "100%" } }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model"]), t(C)(c.permission.save) ? (_(), g(N, { key: 0, size: "default", type: "success", onClick: B(k, ["stop"]), loading: f.value }, { default: o(() => e[4] || (e[4] = [E("保存")])), _: 1, __: [4] }, 8, ["loading"])) : w("", true)]), titleRight: o(() => [t(C)(c.permission.export) ? (_(), g(J, { key: 0, fn: t(X), params: { id: m.currentRow.id }, size: "default" }, { default: o(() => e[5] || (e[5] = [E(" 下载 ")])), _: 1, __: [5] }, 8, ["fn", "params"])) : w("", true)]), content: o(() => [n(t(Z), { "descriptions-list": t(b), "form-detail": t(i), style: { "margin-bottom": "10px" } }, null, 8, ["descriptions-list", "form-detail"]), n(K, { showView: "", "show-download": "", files: t(i).attachmentDTOList, "onUpdate:files": e[2] || (e[2] = (s) => t(i).attachmentDTOList = s), "file-classify": t(Q).RECORD_ATT.V, disabled: true, delDisabled: true }, null, 8, ["files", "file-classify"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, ne = H(ee, [["__scopeId", "data-v-8b653156"]]);
export {
  ne as default
};
