import { inject as G } from "vue";
import { ref as o } from "vue";
import { watch as x } from "vue";
import { nextTick as H } from "vue";
import { computed as O } from "vue";
import { resolveComponent as u } from "vue";
import { openBlock as _ } from "vue";
import { createElementBlock as R } from "vue";
import { withDirectives as y } from "vue";
import { vShow as I } from "vue";
import { createElementVNode as i } from "vue";
import { createVNode as s } from "vue";
import { withCtx as r } from "vue";
import { unref as S } from "vue";
import { createTextVNode as U } from "vue";
import { createBlock as q } from "vue";
import { ElNotification as w } from "element-plus";
import { ElTableColumn as z } from "element-plus";
import { vLoading as A } from "element-plus";
import { g as D, p as M, s as F } from "../../../../../../modules/production-line-team-8367d2ea.js";
import { G as J, dN as K } from "../../../../../../shared/runtime.js";
const Y = { __name: "index", props: { line: { type: Object, default: () => {
} } }, setup(k, { expose: L }) {
  const V = G("maxHeight"), d = o([]), n = o(false), p = o(false), h = o(false), f = o(false), v = o([]), c = o([]), b = k;
  x(() => n.value, (l) => {
    l && H(() => {
      T();
    });
  });
  const m = O(() => b.line && b.line.id);
  x(() => m.value, (l) => {
    l && N();
  }, { immediate: true });
  async function N() {
    try {
      if (c.value = [], !J(K.get)) return;
      h.value = true;
      const l = await D({ id: m.value });
      c.value = (l.teams || []).map((e) => {
        const t = [];
        return e.userLinkList.forEach((a) => {
          a.boolLeaderEnum ? (e.leaderName = a.userName, e.leaderId = a.userId, e.teamId = a.teamId, e.leader = { id: a.userId, name: a.userName }) : t.push({ teamId: a.teamId, id: a.userId, name: a.userName });
        }), e.members = t, e.members.length > 0 ? (e.memberNames = e.members.map((a) => a.name).join(", "), e.memberIds = e.members.map((a) => a.id)) : (e.memberNames = "", e.memberIds = []), e;
      });
    } catch (l) {
      console.log("获取生产班组列表", l);
    } finally {
      h.value = false;
    }
  }
  async function T() {
    var l;
    try {
      v.value = [], f.value = true;
      const { content: e } = await M({ factoryId: (l = b.line) == null ? void 0 : l.factoryId });
      v.value = e.map((t) => (t.leaderName = "", t.userLinkList.forEach((a) => {
        a.boolLeaderEnum && (t.leaderName = a.userName);
      }), t.label = t.leaderName + " - " + t.processName, t)), d.value = c.value.map((t) => t.teamId);
    } catch (e) {
      console.log("获取生产线下所有生产组", e);
    } finally {
      f.value = false;
    }
  }
  async function E() {
    try {
      p.value = true, await F({ id: m.value, teamIds: d.value }), w({ title: "班组绑定成功", type: "success", duration: 2500 }), n.value = false, N();
    } catch (l) {
      console.log(l, "绑定班组");
    } finally {
      p.value = false;
    }
  }
  return L({ toAdd: () => n.value = true }), (l, e) => {
    const t = z, a = u("common-table"), C = u("common-button"), P = u("common-select"), j = u("common-dialog"), B = A;
    return _(), R("div", null, [y(i("div", null, e[2] || (e[2] = [i("div", { class: "my-code" }, "点击生产线查看详情", -1)]), 512), [[I, !m.value]]), y(i("div", null, [s(a, { ref: "tableRef", data: c.value, "max-height": S(V) + 93 }, { default: r(() => [s(t, { label: "序号", type: "index", align: "center", width: "60" }), s(t, { key: "processName", prop: "processName", label: "工序名称", "min-width": "80px", "show-overflow-tooltip": "" }), s(t, { key: "leaderName", prop: "leaderName", label: "组长", "min-width": "80px", "show-overflow-tooltip": "" }), s(t, { key: "memberNames", prop: "memberNames", label: "组员", "min-width": "160px", "show-overflow-tooltip": "" })]), _: 1 }, 8, ["data", "max-height"]), s(j, { title: "选择班组", modelValue: n.value, "onUpdate:modelValue": e[1] || (e[1] = (g) => n.value = g), "before-close": () => {
      n.value = false;
    }, "close-on-click-modal": false, width: "500px" }, { titleRight: r(() => [s(C, { loading: p.value, size: "default", type: "primary", onClick: E }, { default: r(() => e[3] || (e[3] = [U(" 保存 ")])), _: 1, __: [3] }, 8, ["loading"])]), default: r(() => [y((_(), q(P, { modelValue: d.value, "onUpdate:modelValue": e[0] || (e[0] = (g) => d.value = g), options: v.value, type: "other", multiple: "", filterable: "", clearable: "", dataStructure: { key: "id", label: "label", value: "id" }, placeholder: "请选择班组", style: { width: "100%" } }, { empty: r(() => e[4] || (e[4] = [i("div", { style: { "text-align": "center", display: "flex", "flex-direction": "column", padding: "10px", color: "#c0c4cc" } }, [i("span", null, "暂无数据"), i("span", { style: { "margin-top": "5px", color: "#f56c6c" } }, "*请到班组管理进行配置")], -1)])), _: 1 }, 8, ["modelValue", "options"])), [[B, f.value]])]), _: 1 }, 8, ["modelValue", "before-close"])], 512), [[I, m.value]])]);
  };
} };
export {
  Y as default
};
