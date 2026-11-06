import { useStore as D } from "vuex";
import { computed as i } from "vue";
import { watch as _ } from "vue";
import { inject as H } from "vue";
import { ref as y } from "vue";
import { resolveComponent as d } from "vue";
import { openBlock as T } from "vue";
import { createElementBlock as L } from "vue";
import { withDirectives as V } from "vue";
import { vShow as w } from "vue";
import { createElementVNode as s } from "vue";
import { createBlock as R } from "vue";
import { withCtx as u } from "vue";
import { createVNode as r } from "vue";
import { unref as N } from "vue";
import { createTextVNode as U } from "vue";
import { ElNotification as q } from "element-plus";
import { ElTableColumn as z } from "element-plus";
import { vLoading as F } from "element-plus";
import { a as G } from "../../../../../modules/production-line-group-45284ce2.js";
import { aN as J } from "../../../../../shared/runtime.js";
const M = (m) => {
  const a = D(), c = i(() => a.state.config.loaded.bridgeInspectionTeam);
  if (c.value || a.dispatch("config/fetchBridgeInspectionTeam"), m) {
    const p = _(c, (f) => {
      f && setTimeout(() => {
        m(), p();
      }, 0);
    }, { immediate: true });
  }
  return { inspectionTeam: i(() => a.state.config.bridgeInspectionTeam), inspectionTeamKV: i(() => a.state.config.bridgeInspectionTeamKV), loaded: c };
}, X = { __name: "index", props: { modelValue: { type: Array, default: () => [] }, line: { type: Object, default: () => {
} }, group: { type: Object, default: () => {
} } }, emits: ["update:modelValue", "change"], setup(m, { expose: a, emit: c }) {
  const p = H("maxHeight"), { loaded: f, inspectionTeamKV: I, inspectionTeam: k } = M(), o = y([]), l = y(false), g = y(false), x = c, n = m;
  _(() => n.modelValue, (e) => {
    o.value = e;
  }, { immediate: true }), _(() => l.value, (e) => {
    e && (o.value = n.modelValue);
  });
  const v = i(() => n.group && n.group.id), B = i(() => J(n.modelValue.map((e) => I.value[e]))), j = i(() => k.value.filter((e) => {
    var t;
    return e.label = e.processName + " - " + e.inspectorNames, ((t = n.line) == null ? void 0 : t.productType) & e.productType;
  }));
  async function A() {
    try {
      g.value = true, await G({ groupId: v.value, teamIds: o.value }), q({ title: "班组绑定成功", type: "success", duration: 2500 }), l.value = false, x("update:modelValue", o.value), x("change", o.value);
    } catch (e) {
      console.log(e, "绑定班组");
    } finally {
      g.value = false;
    }
  }
  return a({ toAdd: () => l.value = true }), (e, t) => {
    const h = z, S = d("common-table"), C = d("common-button"), E = d("common-select"), K = d("common-dialog"), O = F;
    return T(), L("div", null, [V(s("div", null, t[2] || (t[2] = [s("div", { class: "my-code" }, "点击生产组查看详情", -1)]), 512), [[w, !v.value]]), V(s("div", null, [V((T(), R(S, { ref: "tableRef", returnSourceData: "", data: B.value, "max-height": N(p) + 42 + 55, style: { width: "100%" } }, { default: u(() => [r(h, { key: "processName", prop: "processName", "show-overflow-tooltip": true, label: "工序名称", align: "center", width: "120px" }), r(h, { key: "inspectorNames", prop: "inspectorNames", "show-overflow-tooltip": true, label: "质检", "min-width": "160px" })]), _: 1 }, 8, ["data", "max-height"])), [[O, !N(f)]]), r(K, { title: "选择质检班组", modelValue: l.value, "onUpdate:modelValue": t[1] || (t[1] = (b) => l.value = b), "before-close": () => {
      l.value = false;
    }, "close-on-click-modal": false, width: "500px" }, { titleRight: u(() => [r(C, { loading: g.value, size: "default", type: "primary", onClick: A }, { default: u(() => t[3] || (t[3] = [U(" 保存 ")])), _: 1, __: [3] }, 8, ["loading"])]), default: u(() => [r(E, { modelValue: o.value, "onUpdate:modelValue": t[0] || (t[0] = (b) => o.value = b), options: j.value, type: "other", multiple: "", filterable: "", clearable: "", dataStructure: { key: "id", label: "label", value: "id" }, placeholder: "请选择质检班组", style: { width: "100%" } }, { empty: u(() => t[4] || (t[4] = [s("div", { style: { "text-align": "center", display: "flex", "flex-direction": "column", padding: "10px", color: "#c0c4cc" } }, [s("span", null, "暂无数据"), s("span", { style: { "margin-top": "5px", color: "#f56c6c" } }, "*请到班组管理进行配置")], -1)])), _: 1 }, 8, ["modelValue", "options"])]), _: 1 }, 8, ["modelValue", "before-close"])], 512), [[w, v.value]])]);
  };
} };
export {
  X as default
};
