import { l as i, u as k, x as S, p as B, j0 as O, e2 as m } from "../../../../../shared/runtime.js";
import { inject as J } from "vue";
import { ref as v } from "vue";
import { computed as U } from "vue";
import { watch as L } from "vue";
import { useStore as Y } from "vuex";
import { resolveComponent as C } from "vue";
import { openBlock as b } from "vue";
import { createBlock as j } from "vue";
import { withCtx as A } from "vue";
import { createVNode as z } from "vue";
import { createTextVNode as G } from "vue";
import { resolveDynamicComponent as Z } from "vue";
import { unref as I } from "vue";
import { isRef as H } from "vue";
import { defineAsyncComponent as P } from "vue";
import K from "lodash";
function Q(o) {
  return i({ url: "/api/oa/flow/getFixedData", method: "get", params: o });
}
function W(o) {
  return i({ url: "/api/oa/flow/doCreateAnnualContract/rawMaterial", method: "post", data: o });
}
function X(o) {
  return i({ url: "/api/oa/flow/doCreateAnnualContract", method: "post", data: o });
}
function $(o) {
  return i({ url: "/api/oa/flow/doCreatePurchaseContract/manufacturedGoods", method: "post", data: o });
}
function ee(o) {
  return i({ url: "/api/oa/flow/updateRequestId", method: "put", data: o });
}
const oe = { __name: "index", props: { projectManagerOptions: { type: Array }, visible: { type: Boolean } }, emits: ["update:visible", "reset"], setup(o, { emit: q }) {
  const _ = o, h = q, { visible: y, handleClose: u } = k({ emit: h, props: _, field: "visible" }), c = J("dataId"), r = v(false), g = v(), M = { 1: P(() => O(() => import("./materials/index.vue.js"), ["static/js/index-a16c813a.js", "static/js/materials-3c99534f.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/index-50216080.js", "static/css/index-685b5588.css", "static/js/UploadList-ad01af55.js", "static/css/UploadList-d7d36eff.css", "static/js/index-f80f68af.js", "static/js/use-users-4d979987.js", "static/css/materials-f36e5144.css", "static/js/materials-year-dc08e148.js", "static/css/materials-year-35b1c805.css"])), 2: P(() => O(() => import("./finished.vue.js"), ["static/js/finished-c88910f6.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/index-50216080.js", "static/css/index-685b5588.css", "static/js/UploadList-ad01af55.js", "static/css/UploadList-d7d36eff.css", "static/css/finished-78e4bbd7.css"])) }, N = U(() => M[g.value]), { crud: p } = S({ title: "OA审批" });
  L(() => c.value, async (t) => {
    t && await T(t);
  });
  const f = v();
  async function T(t) {
    try {
      f.value = await Q({ dataId: t, businessType: 1 }), g.value = f.value.purchaseType;
    } catch (e) {
      console.log("获取采购信息失败", e);
    }
  }
  const l = v();
  async function x(t) {
    try {
      r.value = true;
      const e = await W(t);
      l.value = JSON.parse(e).requestid, m("success", "审批发起成功"), u();
    } catch (e) {
      console.log("原材料审批报错:fetchMaterialsPostApproval", e);
    } finally {
      r.value = false;
    }
  }
  async function D(t) {
    try {
      r.value = true;
      const e = await X(t);
      l.value = JSON.parse(e).requestid, m("success", "审批发起成功"), u();
    } catch (e) {
      console.log("原材料年度审批报错", e);
    } finally {
      r.value = false;
    }
  }
  async function F(t) {
    try {
      r.value = true;
      const e = await $(t);
      l.value = JSON.parse(e).requestid, m("success", "审批发起成功"), u();
    } catch (e) {
      console.log("制成品审批报错:fetchFinishedPostApproval", e);
    } finally {
      r.value = false;
    }
  }
  const V = Y();
  async function w({ requestName: t }) {
    try {
      if (!(c.value && l.value)) return;
      await ee({ businessType: 1, id: c.value, requestId: l.value, requestName: t, applicationId: V.getters.user.id, applicationTime: (/* @__PURE__ */ new Date()).getTime(), modeOperation: 1 }), h("reset"), c.value = null, l.value = null;
    } catch (e) {
      m("danager", "关联表绑定失败"), console.log("id绑定失败:putOaApproval", e);
    }
  }
  const E = async () => {
    p.ref.form.validate(async (t) => {
      var e, d;
      if (t) {
        const a = K.cloneDeep(p.form), { orderDetailAttachment: s } = a;
        Object.keys(a).forEach((n) => {
          n !== "htfj" && (a[n] = p.form[n] + "");
        }), s != null && s.length && s[0] !== null && (Array.isArray(a.htfj) ? a.htfj.push(...s) : a.htfj = [...s]), delete a.orderDetailAttachment, (e = a.htfj) != null && e.length ? a.htfj = a.htfj.map((n) => {
          if (n) return { fileName: n.name, filePath: n.relativePath };
        }) : delete a.htfj, a.sqrq = B(a.sqrq, "{y}-{m}-{d}"), g.value === 1 ? (d = f.value) != null && d.boolAnnual ? (await D(a), await w({ requestName: "材料合同审批流程（初鸣）" })) : (await x(a), await w({ requestName: "材料合同审批流程（初鸣）" })) : (await F(a), await w({ requestName: "外委加工合同审批/结算流程（初鸣）" }));
      }
    });
  };
  async function R() {
    await p.cancelCU(), h("reset");
  }
  return (t, e) => {
    const d = C("common-button"), a = C("common-dialog");
    return b(), j(a, { modelValue: I(y), "onUpdate:modelValue": e[0] || (e[0] = (s) => H(y) ? y.value = s : null), "before-close": I(u), closeOnClickModal: false, closeOnPressEscape: false, "destroy-on-close": true, title: "OA审批", top: "1vh", width: "900px", onClose: R }, { titleRight: A(() => [z(d, { loading: r.value, size: "mini", type: "primary", onClick: E }, { default: A(() => e[1] || (e[1] = [G("提交")])), _: 1, __: [1] }, 8, ["loading"])]), default: A(() => [(b(), j(Z(N.value), { projectManagerOptions: _.projectManagerOptions, purchaseInfo: f.value }, null, 8, ["projectManagerOptions", "purchaseInfo"]))]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  oe as default
};
