import { j0 as n } from "../../../../../../../shared/runtime.js";
import { g as l } from "../../../../../../../modules/index-70e7196a.js";
import { ref as p } from "vue";
import { inject as s } from "vue";
import { watch as _ } from "vue";
import { computed as f } from "vue";
import { openBlock as v } from "vue";
import { createBlock as y } from "vue";
import { resolveDynamicComponent as d } from "vue";
import { defineAsyncComponent as c } from "vue";
const A = { __name: "index", setup(g) {
  const o = p(), { dataId: a } = s("common"), r = s("settleSubmitType");
  _(() => a == null ? void 0 : a.value, async (e) => {
    e && (console.log(e, "newVal"), await u(e));
  }, { immediate: true });
  async function u(e) {
    try {
      const t = await l({ dataId: e, businessType: 3 });
      o.value = t, r.value = o.value.purchaseType, console.log(o.value, "------");
    } catch (t) {
      console.log("获取采购信息失败：getPurchaseInfo", t);
    }
  }
  const i = { 1: c(() => n(() => import("./materials.vue.js"), ["static/js/materials-a6b0e444.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/index-50216080.js", "static/css/index-685b5588.css", "static/js/UploadList-ad01af55.js", "static/css/UploadList-d7d36eff.css", "static/css/materials-6f131b45.css"])), 2: c(() => n(() => import("./finished.vue.js"), ["static/js/finished-f8565540.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/index-50216080.js", "static/css/index-685b5588.css", "static/js/UploadList-ad01af55.js", "static/css/UploadList-d7d36eff.css", "static/css/finished-f32ad280.css"])) }, m = f(() => {
    var e;
    return i[(e = o == null ? void 0 : o.value) == null ? void 0 : e.purchaseType];
  });
  return (e, t) => (v(), y(d(m.value), { info: o.value }, null, 8, ["info"]));
} };
export {
  A as default
};
