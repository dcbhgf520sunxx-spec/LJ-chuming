import { inject as p } from "vue";
import { ref as a } from "vue";
import { provide as m } from "vue";
import { computed as f } from "vue";
import { reactive as D } from "vue";
import { watch as M } from "vue";
import { openBlock as w } from "vue";
import { createBlock as _ } from "vue";
import { withCtx as l } from "vue";
import { createVNode as v } from "vue";
import { createTextVNode as I } from "vue";
import { toDisplayString as N } from "vue";
import { resolveDynamicComponent as V } from "vue";
import { nextTick as R } from "vue";
import { ElButton as B } from "element-plus";
import { ElDrawer as E } from "element-plus";
import J from "./calculation/index.vue.js";
import W from "./reverse-thrust/index.vue.js";
import { dp as H, e2 as g, e6 as P } from "../../../../../shared/runtime.js";
import { e as U, f as $, h as q, i as G, a as K } from "../../../../../modules/project-assembly-welding-config-107f9ee1.js";
import "../../../../../modules/cutting-config-59e818a6.js";
const oe = { __name: "index", setup(Q, { expose: S }) {
  const o = p("projectData"), s = a(false), b = a(false), c = a(""), C = a([]);
  m("saveList", C);
  const L = f(() => o ? U : $), T = f(() => o ? q : G), r = D({ machinePartType: "", steelClassificationId: null }), n = D({ artifactTypeId: null, artifactNameList: [], processIdList: null, detailList: [{ comparisonOperatorOne: "", comparisonOperatorTwo: "", numberOne: "", numberTwo: "", organizationInsidePrice: "", organizationOutsidePrice: "" }], organizationInsidePrice: null, organizationOutsidePrice: null });
  m("reverSetFromData", r), m("calculationFormData", n);
  const { radio: h } = p("headerData"), { tableRef: A } = p("parentData"), u = a(null), O = a("35%"), k = [null, J, W], x = f(() => k[h.value]), d = a(null);
  M([() => r, () => n], ([e, t]) => {
    e.id || t.id ? c.value = "修改" : c.value = "创建";
  }, { deep: true, immediate: true }), (async () => {
    try {
      const e = await K();
      e.id && (u.value = e.mode);
    } catch (e) {
      console.log(e);
    }
  })();
  const z = async () => {
    try {
      await Promise.all(C.value.map((i) => i()));
      const e = d.value.formData, t = JSON.parse(JSON.stringify(e));
      if (t.processIdList = [t.processIdList], u.value) e.statisticsConfigStatisticsMode = u.value;
      else return g("error", "请先前往统计配置页面配置模式");
      e.id ? (await T.value({ ...t, contractProjectId: o ? o.contractProjectId : null }), g("success", "修改成功")) : (await L.value(t), g("success", "创建成功")), s.value = false, A.value.getSparePartsConfigList();
    } catch (e) {
      console.error("创建或修改失败;" + e);
    }
  }, j = async () => {
    s.value = false, await R(() => {
      P(r), P(n);
    });
  };
  return S({ visible: s, reverSetFromData: r, currentComponentRef: d, calculationFormData: n }), (e, t) => {
    const i = B, F = E;
    return w(), _(F, { modelValue: s.value, "onUpdate:modelValue": t[1] || (t[1] = (y) => s.value = y), "close-on-click-modal": false, "close-on-press-escape": false, size: O.value, "destroy-on-close": "", "show-close": false, onClosed: j }, { header: l(() => [v(H, { "header-title": "装焊配置", "type-one": false }), v(i, { plain: "", onClick: t[0] || (t[0] = (y) => s.value = false) }, { default: l(() => t[2] || (t[2] = [I("关闭")])), _: 1, __: [2] }), v(i, { type: "success", onClick: z, loading: b.value }, { default: l(() => [I(N(c.value), 1)]), _: 1 }, 8, ["loading"])]), default: l(() => [(w(), _(V(x.value), { ref_key: "currentComponentRef", ref: d }, null, 512))]), _: 1 }, 8, ["modelValue", "size"]);
  };
} };
export {
  oe as default
};
