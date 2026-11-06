import { useStore as O } from "vuex";
import { computed as s } from "vue";
import { watch as x } from "vue";
import { inject as D } from "vue";
import { ref as V } from "vue";
import { resolveComponent as d } from "vue";
import { openBlock as h } from "vue";
import { createElementBlock as H } from "vue";
import { withDirectives as _ } from "vue";
import { vShow as w } from "vue";
import { createElementVNode as i } from "vue";
import { createBlock as R } from "vue";
import { withCtx as m } from "vue";
import { createVNode as r } from "vue";
import { unref as N } from "vue";
import { createTextVNode as U } from "vue";
import { ElNotification as q } from "element-plus";
import { ElTableColumn as z } from "element-plus";
import { vLoading as F } from "element-plus";
import { p as G } from "../../../../../modules/production-line-group-49cd597d.js";
import { aN as J } from "../../../../../shared/runtime.js";
const M = (p) => {
  const l = O(), c = s(() => l.state.config.loaded.inspectionTeam);
  if (c.value || l.dispatch("config/fetchInspectionTeam"), p) {
    const f = x(c, (v) => {
      v && setTimeout(() => {
        p(), f();
      }, 0);
    }, { immediate: true });
  }
  return { inspectionTeam: s(() => l.state.config.inspectionTeam), inspectionTeamKV: s(() => l.state.config.inspectionTeamKV), loaded: c };
}, X = { __name: "index", props: { modelValue: { type: Array, default: () => [] }, line: { type: Object, default: () => {
} }, group: { type: Object, default: () => {
} } }, emits: ["update:modelValue", "change"], setup(p, { expose: l, emit: c }) {
  const f = D("maxHeight"), { loaded: v, inspectionTeamKV: k, inspectionTeam: I } = M(), o = V([]), n = V(false), g = V(false), T = c, a = p;
  x(() => a.modelValue, (e) => {
    o.value = e;
  }, { immediate: true }), x(() => n.value, (e) => {
    e && (o.value = a.modelValue);
  });
  const y = s(() => a.group && a.group.id), E = s(() => J(a.modelValue.map((e) => k.value[e]))), j = s(() => I.value.filter((e) => {
    var t, u;
    return e.label = e.processName + " - " + e.inspectorNames, ((t = a.line) == null ? void 0 : t.productType) & e.productType && ((u = a.line) == null ? void 0 : u.productionLineTypeEnum) === e.productionLineTypeEnum;
  }));
  async function A() {
    try {
      g.value = true, await G({ groupId: y.value, teamIds: o.value }), q({ title: "班组绑定成功", type: "success", duration: 2500 }), n.value = false, T("update:modelValue", o.value), T("change", o.value);
    } catch (e) {
      console.log(e, "绑定班组");
    } finally {
      g.value = false;
    }
  }
  return l({ toAdd: () => n.value = true }), (e, t) => {
    const u = z, L = d("common-table"), S = d("common-button"), B = d("common-select"), C = d("common-dialog"), K = F;
    return h(), H("div", null, [_(i("div", null, t[2] || (t[2] = [i("div", { class: "my-code" }, "点击生产组查看详情", -1)]), 512), [[w, !y.value]]), _(i("div", null, [_((h(), R(L, { ref: "tableRef", returnSourceData: "", data: E.value, "max-height": N(f) + 42 + 55, style: { width: "100%" } }, { default: m(() => [r(u, { key: "processName", prop: "processName", "show-overflow-tooltip": true, label: "工序名称", align: "center", width: "120px" }), r(u, { key: "inspectorNames", prop: "inspectorNames", "show-overflow-tooltip": true, label: "质检", "min-width": "160px" })]), _: 1 }, 8, ["data", "max-height"])), [[K, !N(v)]]), r(C, { title: "选择质检班组", modelValue: n.value, "onUpdate:modelValue": t[1] || (t[1] = (b) => n.value = b), "before-close": () => {
      n.value = false;
    }, "close-on-click-modal": false, width: "500px" }, { titleRight: m(() => [r(S, { loading: g.value, size: "default", type: "primary", onClick: A }, { default: m(() => t[3] || (t[3] = [U(" 保存 ")])), _: 1, __: [3] }, 8, ["loading"])]), default: m(() => [r(B, { modelValue: o.value, "onUpdate:modelValue": t[0] || (t[0] = (b) => o.value = b), options: j.value, type: "other", multiple: "", filterable: "", clearable: "", dataStructure: { key: "id", label: "label", value: "id" }, placeholder: "请选择质检班组", style: { width: "100%" } }, { empty: m(() => t[4] || (t[4] = [i("div", { style: { "text-align": "center", display: "flex", "flex-direction": "column", padding: "10px", color: "#c0c4cc" } }, [i("span", null, "暂无数据"), i("span", { style: { "margin-top": "5px", color: "#f56c6c" } }, "*请到班组管理进行配置")], -1)])), _: 1 }, 8, ["modelValue", "options"])]), _: 1 }, 8, ["modelValue", "before-close"])], 512), [[w, y.value]])]);
  };
} };
export {
  X as default
};
