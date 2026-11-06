import { l as h, u as S, x as J, p as L, j0 as A, e2 as m } from "../../../../../shared/runtime.js";
import { g as U } from "../../../../../modules/index-70e7196a.js";
import { ref as r } from "vue";
import { inject as z } from "vue";
import { computed as G } from "vue";
import { watch as H } from "vue";
import { useStore as Z } from "vuex";
import { resolveComponent as O } from "vue";
import { openBlock as b } from "vue";
import { createBlock as j } from "vue";
import { withCtx as v } from "vue";
import { createVNode as K } from "vue";
import { createTextVNode as Q } from "vue";
import { resolveDynamicComponent as W } from "vue";
import { unref as I } from "vue";
import { isRef as X } from "vue";
import { defineAsyncComponent as C } from "vue";
import P from "lodash";
function Y(o) {
  return h({ url: "/api/oa/flow/doCreateAnnualContract/rawMaterial", method: "post", data: o });
}
function $(o) {
  return h({ url: "/api/oa/flow/doCreatePurchaseContract/manufacturedGoods", method: "post", data: o });
}
function ee(o) {
  return h({ url: "/api/oa/flow/updateRequestId", method: "put", data: o });
}
const se = { __name: "index", props: { projectManagerOptions: { type: Array }, visible: { type: Boolean }, originForm: { type: Object, default: () => {
} } }, emits: ["update:visible", "reset"], setup(o, { emit: q }) {
  const y = o, g = q, { visible: l, handleClose: c } = S({ emit: g, props: y, field: "visible", showHook: T }), u = r({}), p = z("dataId"), _ = r();
  function M() {
    _.value = Math.random();
  }
  function T() {
    M();
  }
  const n = r(false), V = { 1: C(() => A(() => import("./materials.vue.js"), ["static/js/materials-66deb0db.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/index-50216080.js", "static/css/index-685b5588.css", "static/js/UploadList-ad01af55.js", "static/css/UploadList-d7d36eff.css", "static/css/materials-ed8d1b18.css"])), 2: C(() => A(() => import("./finished.vue.js"), ["static/js/finished-af680dca.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/index-50216080.js", "static/css/index-685b5588.css", "static/js/UploadList-ad01af55.js", "static/css/UploadList-d7d36eff.css", "static/css/finished-bf935135.css"])) }, k = G(() => V[d.value]), { crud: f } = J({ title: "OA审批" });
  H(() => p.value, async (t) => {
    await D(t);
  });
  const d = r();
  async function D(t) {
    try {
      u.value = await U({ dataId: t, businessType: 1 }), d.value = u.value.purchaseType;
    } catch (e) {
      console.log("获取采购信息失败", e);
    }
  }
  const i = r();
  async function x(t) {
    try {
      n.value = true;
      const e = await Y(t);
      i.value = JSON.parse(e).requestid, m("success", "审批发起成功"), c();
    } catch (e) {
      console.log("原材料审批报错:fetchMaterialsPostApproval", e);
    } finally {
      n.value = false;
    }
  }
  async function E(t) {
    try {
      n.value = true;
      const e = await $(t);
      i.value = JSON.parse(e).requestid, m("success", "审批发起成功"), c();
    } catch (e) {
      console.log("制成品审批报错:fetchFinishedPostApproval", e);
    } finally {
      n.value = false;
    }
  }
  const F = Z();
  async function w({ requestName: t }) {
    try {
      if (!(p.value && i.value)) return;
      await ee({ businessType: 1, id: p.value, requestId: i.value, requestName: t, applicationId: F.getters.user.id, applicationTime: (/* @__PURE__ */ new Date()).getTime(), modeOperation: 2 }), g("reset");
    } catch (e) {
      m("danager", "关联表绑定失败"), console.log("id绑定失败:putOaApproval", e);
    }
  }
  async function N(t, e) {
    if (!e.length) {
      t.htfj = [];
      return;
    }
    t.htfj = e.map((a) => ({ fileName: a.name, filePath: a.relativePath }));
  }
  const R = async () => {
    f.ref.form.validate(async (t) => {
      var e;
      if (t) {
        const a = P.cloneDeep(f.form);
        if (await Object.keys(a).forEach((s) => {
          a[s] = f.form[s] + "";
        }), a.sqrq = L(a.sqrq, "{y}-{m}-{d}"), (e = a.htfj) != null && e.length) {
          const s = P.cloneDeep(a.htfj);
          delete a.htfj, await N(a, s);
        } else delete a.htfj;
        d.value === 1 ? (await x(a), await w({ requestName: "材料合同审批流程（初鸣）" })) : (await E(a), await w({ requestName: "外委加工合同审批/结算流程（初鸣）" }));
      }
    });
  };
  return (t, e) => {
    const a = O("common-button"), s = O("common-dialog");
    return b(), j(s, { modelValue: I(l), "onUpdate:modelValue": e[0] || (e[0] = (B) => X(l) ? l.value = B : null), "before-close": I(c), closeOnClickModal: false, closeOnPressEscape: false, title: "OA审批", top: "1vh", width: "900px" }, { titleRight: v(() => [K(a, { loading: n.value, size: "mini", type: "primary", onClick: R }, { default: v(() => e[1] || (e[1] = [Q("提交")])), _: 1, __: [1] }, 8, ["loading"])]), default: v(() => [(b(), j(W(k.value), { key: _.value, projectManagerOptions: y.projectManagerOptions, purchaseInfo: u.value }, null, 8, ["projectManagerOptions", "purchaseInfo"]))]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  se as default
};
