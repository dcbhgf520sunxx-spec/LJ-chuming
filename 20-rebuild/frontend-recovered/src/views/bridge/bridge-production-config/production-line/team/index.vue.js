import { useStore as D } from "vuex";
import { computed as r } from "vue";
import { watch as V } from "vue";
import { inject as H } from "vue";
import { ref as p } from "vue";
import { resolveComponent as f } from "vue";
import { openBlock as h } from "vue";
import { createElementBlock as Q } from "vue";
import { withDirectives as w } from "vue";
import { vShow as N } from "vue";
import { createElementVNode as t } from "vue";
import { createBlock as q } from "vue";
import { withCtx as n } from "vue";
import { createVNode as u } from "vue";
import { createTextVNode as B } from "vue";
import { toDisplayString as K } from "vue";
import { unref as P } from "vue";
import { ElNotification as z } from "element-plus";
import { ElTableColumn as F } from "element-plus";
import { vLoading as $ } from "element-plus";
import { p as G } from "../../../../../modules/production-line-group-45284ce2.js";
import { aN as J, aR as M, aT as W } from "../../../../../shared/runtime.js";
const X = (c) => {
  const s = D(), m = r(() => s.state.config.loaded.bridgeProductionTeam);
  if (m.value || s.dispatch("config/fetchBridgeProductionTeam"), c) {
    const v = V(m, (g) => {
      g && setTimeout(() => {
        c(), v();
      }, 0);
    }, { immediate: true });
  }
  return { productionTeam: r(() => s.state.config.bridgeProductionTeam), productionTeamKV: r(() => s.state.config.bridgeProductionTeamKV), loaded: m };
}, ae = { __name: "index", props: { modelValue: { type: Array, default: () => [] }, line: { type: Object, default: () => {
} }, group: { type: Object, default: () => {
} } }, emits: ["update:modelValue", "change"], setup(c, { expose: s, emit: m }) {
  const v = [["wageQuotaType", ["parse-enum", W, { f: "SL", extra: "计价" }]]], g = H("maxHeight"), y = p([]), { loaded: R, productionTeamKV: S, productionTeam: j } = X(), l = p([]), d = p(false), x = p(false), _ = m, i = c;
  V(() => i.modelValue, (a) => {
    l.value = a;
  }, { immediate: true }), V(() => d.value, (a) => {
    a && (l.value = i.modelValue);
  });
  const b = r(() => i.group && i.group.id), T = r(() => J(i.modelValue.map((a) => S.value[a]))), A = r(() => j.value.filter((a) => {
    var e;
    return ((e = i.line) == null ? void 0 : e.productType) & a.productType;
  }));
  async function C() {
    try {
      x.value = true, await G({ groupId: b.value, teamIds: l.value }), z({ title: "班组绑定成功", type: "success", duration: 2500 }), d.value = false, _("update:modelValue", l.value), _("change", l.value);
    } catch (a) {
      console.log(a, "绑定班组");
    } finally {
      x.value = false;
    }
  }
  return s({ toAdd: () => d.value = true }), (a, e) => {
    const k = F, E = f("common-table"), I = f("common-button"), L = f("common-select"), O = f("common-dialog"), U = $;
    return h(), Q("div", null, [w(t("div", null, e[3] || (e[3] = [t("div", { class: "my-code" }, "点击生产组查看详情", -1)]), 512), [[N, !b.value]]), w(t("div", null, [w((h(), q(E, { ref: "tableRef", data: T.value, "data-format": v, "max-height": P(g) + 135, "default-expand-all": false, "expand-row-keys": y.value, "row-key": "id", style: { width: "100%" } }, { default: n(() => [u(M, { data: T.value, "expand-row-keys": y.value, "onUpdate:expandRowKeys": e[0] || (e[0] = (o) => y.value = o), "row-key": "id", fixed: "left" }, { default: n(({ row: o }) => [t("p", null, [e[4] || (e[4] = B(" 组员：")), t("span", null, K(o.memberNames), 1)])]), _: 1 }, 8, ["data", "expand-row-keys"]), u(k, { key: "processName", prop: "processName", "show-overflow-tooltip": true, label: "工序名称", "min-width": "100px", align: "center" }, { default: n(({ row: o }) => [t("span", null, K(o.processName), 1)]), _: 1 }), u(k, { key: "leaderName", prop: "leaderName", label: "组长", "min-width": "100px" })]), _: 1 }, 8, ["data", "max-height", "expand-row-keys"])), [[U, !P(R)]]), u(O, { title: "选择班组", modelValue: d.value, "onUpdate:modelValue": e[2] || (e[2] = (o) => d.value = o), "before-close": () => {
      d.value = false;
    }, "close-on-click-modal": false, width: "500px" }, { titleRight: n(() => [u(I, { loading: x.value, size: "default", type: "primary", onClick: C }, { default: n(() => e[5] || (e[5] = [B(" 保存 ")])), _: 1, __: [5] }, 8, ["loading"])]), default: n(() => [u(L, { modelValue: l.value, "onUpdate:modelValue": e[1] || (e[1] = (o) => l.value = o), options: A.value, type: "other", multiple: "", filterable: "", clearable: "", dataStructure: { key: "id", label: "label", value: "id" }, placeholder: "请选择班组", style: { width: "100%" } }, { empty: n(() => e[6] || (e[6] = [t("div", { style: { "text-align": "center", display: "flex", "flex-direction": "column", padding: "10px", color: "#c0c4cc" } }, [t("span", null, "暂无数据"), t("span", { style: { "margin-top": "5px", color: "#f56c6c" } }, "*请到班组管理进行配置")], -1)])), _: 1 }, 8, ["modelValue", "options"])]), _: 1 }, 8, ["modelValue", "before-close"])], 512), [[N, b.value]])]);
  };
} };
export {
  ae as default
};
